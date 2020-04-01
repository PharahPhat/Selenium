client=$1
API=$2
group=$3
environment=$4

email=varun.bhatia@sandata.com,neeraj.kumar@sandata.com,ravi.ranjan@sandata.com,shailendra.pal@sandata.com,Rahul.Rohitashwar@sandata.com
sender=InteropAutomation@CLI

file=target/surefire-reports/testng-results.xml
file1=target/surefire-reports/TestSuite.txt
#Extracting results for test run
pass="$(xmllint --xpath "string(//testng-results/@passed)" ${file})"
failures="$(xmllint --xpath "string(//testng-results/@failed)" ${file})"
error="$(cut -d',' -f1 <<<$(awk '/Errors:/{print $7}' ${file1}))"
skip="$(xmllint --xpath "string(//testng-results/@skipped)" ${file})"
total="$(xmllint --xpath "string(//testng-results/@total)" ${file})"
ignored="$(xmllint --xpath "string(//testng-results/@ignored)" ${file})"
actual_total=$((total-ignored))

sudo touch finalresult_interop
sudo chmod 777 finalresult_interop
echo -e "TOTAL=$actual_total\nPASS=$pass\nFAIL=$failures\nERROR=$error\nSKIP=$skip">>finalresult_interop
echo -e "<!DOCTYPE html><html><head><meta charset="ISO-8859-1"><title>InterOp Payer Automation results</title><style type="text/css">table{width: 500px}table,th,td{border: 1px solid black;text-align: center;}th,td{padding: 5px;}table tr:nth-child(even){background-color: #fcc;}table tr:nth-child(odd){background-color: #cfc;}table th {color: white;background-color: black;}</style></head><body><p>Hi Team</p><p>Test execution for Interop Payer is complete. Summary of results is in the below table.</p><table><tbody><tr><td bgcolor="#81BEF7"><b>Total Cases</b></td><td bgcolor="#58FA82"><b>Pass Count</b></td><td bgcolor="#F7819F"><b>Fail Count</b></td><td bgcolor="#ffff80"><b>Error Count</b></td><td bgcolor="#c6a5f3"><b>Skip Count</b></tr><tr><td>$actual_total</td><td>$pass</td><td>$failures</td><td>$error</td><td>$skip</td></tr></tbody></table><br><table><tbody><tr><td bgcolor="#F1DD2E"><b>Client</b></td><td bgcolor="#FE752C"><b>API</b></td><td bgcolor="#81BEF7"><b>Environment</b></td><td bgcolor="#ffff80"><b>TestNG group</b></td></tr><tr><td>$client</td><td>$API</td><td>$environment</td><td>$group</td></tr></tbody></table><br><p>Thanks</p><p>QA Team</p></body></html>" | mailx -s "InterOp Automation results for $client::$API::$environment" -A  test-output/Extent*.html -a 'Content-Type: text/html' -a "From:$sender" $email
