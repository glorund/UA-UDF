create table agents (f1 string,f2 string, f3 string, f4 string, agent string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';
LOAD DATA INPATH '/imp.20130311.txt' INTO TABLE agents;

ADD JAR target/UA-UDF-0.0.1-SNAPSHOT-jar-with-dependencies.jar;
create temporary function parseua as 'com.epam.hive.udf.UserAgentParser';
select ret[0],ret[1] from (select MultiUDF(nId) as ret from myTable) bar;
select ret["device"],ret["OS"],ret["Browser"],ret["UA"] from (select parseua(agent) as ret from agents) bar limit 10;
