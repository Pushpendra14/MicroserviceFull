* Extract Hsqldb *(It's in the common share)*
* Go to **bin** folder
* Click **runServer** to start the server
* Click **runManager** to start the client

* create a database **training**
* create a table **persons**

```sql
create schema training;
create table persons(
	id integer identity primary key,
	name varchar(40),
	age int
	);
```


 