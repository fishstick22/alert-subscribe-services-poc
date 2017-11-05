#!/usr/bin/perl
#-------------------------------------------------------------------------------------------------
# clientlist.pl -- parse the TCLT worksheet, make SQL, etc
# Example:
# C:\Users\U92AQLF\Perl\alertsubscribe>perl clientlist.pl -dc -f TCLT_CLIENT-test.csv -env test
#

# 
#-------------------------------------------------------------------------------------------------
use warnings;
use strict;
use threads;
use Data::Dumper;
use Text::CSV_XS;
STDOUT->autoflush(1);
#-------------------------------------------------------------------------------------------------
#
#-------------------------------------------------------------------------------------------------

my %options = initopts();
my @data = readcsv($options{f}, $options{d});
makesql(\@data, $options{d});

exit 0;

#-------------------------------------------------------------------------------------------------
sub makesql {

	my ($hashlist, $debug) = @_;

	my $first =1;

	#print Dumper (@$hashlist) if $debug;
	print "INSERT INTO `client` (`id`, `code`, `name`) VALUES ";

	foreach my $datarowref (@$hashlist) {

		#print Dumper ($datarowref) if $debug;

		if ($first) {
			$first =0;
		}else{
			print ",";
		}
		print "\n";

		my %datarow = %$datarowref;
		print "\t (", $datarow{'CLT_ID'}, ", '", $datarow{'CLT_CD'}, "', '", $datarow{'CLT_NM'}, "')" ;

	}
	print ";";
}

#-------------------------------------------------------------------------------------------------
sub readcsv {

	my ($file, $debug) = @_;

	my $csv = Text::CSV_XS->new({ binary => 1, escape_char => undef });
	my (@fields, @datahashlist);
	my $counter=0;
	my $first =1;

	open my $io, "<", $file or die "$file: $!";

	while (my $row = $csv->getline ($io) ) {
		#print "row: ", $counter, " : $row  ... ", @$row, "\n" if ($debug);
		if ($first) {
			@fields = @$row;
			$first =0;
			next;
		}else{
			++$counter;
			my @data = @$row;
			my %datarow = ();
			for (my $ix=0; $ix<@fields; $ix++){ 
				print $ix, ": ", $fields[$ix], " = ", $data[$ix], "\n" if ($debug);
				$datarow{$fields[$ix]} = $data[$ix]; 
			}
			push @datahashlist, \%datarow;
		}
	}
	print "while loop exited after $counter rows ",$csv->error_diag()," \n";
	close $io;

	return @datahashlist;
}

sub initopts {

	use Getopt::Std;

	my %opts = ();

	getopts("hdcsf:e:", \%opts) or usage();
	usage() if $opts{h};

	#$debug=defined $opts{d}?1:0;
	#$usecsv=defined $opts{c}?1:0;
	#$writesql=defined $opts{s}?1:0;;

	#if (defined $opts{f}){ $file=$opts{f} }else{ print "\n\nFATAL: must specify a file!\n\n"; usage(); };
	#if (defined $opts{e}){ $env=$opts{e} }else{ print "\n\nFATAL: must specify env!\n\n"; usage(); };

	if (not defined $opts{f}){ print "\n\nFATAL: must specify a file!\n\n"; usage(); };

	return %opts;
}


sub usage {

	print STDERR << "EOF";

	list.pl -- parse the parse the TCLT worksheet, make SQL, etc

	usage: $0 [-hdcs] [-f file] [-e env]

	 -h        : this (help) message
	 -d        : turn on debugging output
	 -c        : input file is CSV 
	 -s        : output SQL inserts
	 -f file   : file containing data to process ( definitions) REQUIRED
	 -e env    : name of the environment (file must exist {env}.envprops) REQUIRED
EOF
   exit;
}
