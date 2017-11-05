#!/usr/bin/perl
#-------------------------------------------------------------------------------------------------
# alertlist.pl -- parse the CMP Alert List worksheet, make SQL, etc
# Example:
# C:\Users\U92AQLF\Perl\alertlist>perl alertlist.pl -dc -f ListofAlerts-test.csv -env test
#
# 0: Alert = Order Shipped
# 1: Description = Notifies a member when their order is shipped
# 2: Alert # = 264
# 3: Timing = Real-time
# 4: Batch Run Times (CST) =
# 5: Current Priority = 3
# 6: Portrait Priority = 2
# 7: Alert Type = Order Status
# 8: Alert Category = Order Catergory
# 9: Mandatory Alert = NO
# 10: Triggered By = LINKS
# 11: Project Associated =
# 12: Volume Based on Sept  2 = 151332
# 13: Monthly Projection in Sept = 4,691,292
# 14: Volume Projected Per Month =
# 15: Branding =
# 16: Live Date = Client Secure channel live date-04/15/2016
# 17: Retired Date =
# 18: Added to Egain Reports =
# 19: Secure MQ Migrated = Y
# 20: Project / Major     Secure MQ Migrated = ITPR018602 - Delivery Dates Phase 1
#        August 2017 Major
# 21: Portrait Migrated  =
# 22: Portrait Migrated Channel = Email, Secure (August Major), SMS (May Minor)
# 23: CMP Delivery Channels Available* = Email/Phone/Text Message/Secure/Client Se
# cure Message
# 24: Input Queue Name = ECCM.MSG.REQUEST
# 25: Lower Environment Test XML Location = http://sharepoint/sites/ccms/MIC/MIC%2
# 0Products%20Knowledge%20Base/ECCM%20Environment%20Support/Lower%20Environment%20
# Test%20XML/Order%20Shipped.xml
# 26: Notes = * Will be triggered by LINKS as part of the Existing Order Status pr
# oject (Aug 2014)* Goes through legacy CMP for Phone, Text and Secure Message ale
# rts
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
my @alertdata = readcsv($options{f}, $options{d});
makesql(\@alertdata, $options{d});

exit 0;

#-------------------------------------------------------------------------------------------------
sub makesql {

	my ($alerthashlist, $debug) = @_;

	my $first =1;

	#print Dumper (@$alerthashlist) if $debug;
	print "INSERT INTO `communication` (`id`, `name`, `description`) VALUES ";

	foreach my $datarowref (@$alerthashlist) {

		#print Dumper ($datarowref) if $debug;

		if ($first) {
			$first =0;
		}else{
			print ",";
		}
		print "\n";

		my %datarow = %$datarowref;
		print "\t (", $datarow{'Alert #'}, ", \"", $datarow{'Alert'}, "\", \"", $datarow{'Description'}, "\")" ;

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

	alertlist.pl -- parse the CMP Alert List worksheet, make SQL, etc

	usage: $0 [-hdcs] [-f file] [-e env]

	 -h        : this (help) message
	 -d        : turn on debugging output
	 -c        : input file is CSV 
	 -s        : output SQL inserts
	 -f file   : file containing data to process (alert definitions) REQUIRED
	 -e env    : name of the environment (file must exist {env}.envprops) REQUIRED
EOF
   exit;
}
