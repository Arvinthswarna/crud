import java.sql.DriverManager
//model class
 data class User(val id:Int,val name:String,val age:Int,val email:String,val phone:Int,val city:String,val state:String,val country:String,val pincode:Int)
// the user in data class doesnt indicate the table in mysql.it can be user or item or whatevr we wish
fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb"
    val connection = DriverManager.getConnection(jdbcUrl,"root","Arvinth@97")
    println(connection.isValid(0))


//insert query - Create
  val insert_res = connection.createStatement().executeUpdate("insert into users(name,age,email,phone,city,state,country,pincode)values('dhawan',28,'dhawan@gmail.com','1234567899','punjab','PJ','IND',638007)")
               if(insert_res>0){
    println("successfully inserted records into users")
                }else{
                    println("Insert not successful")
                }
//delete query-delete
val delete_res = connection.createStatement().executeUpdate("delete from users where id = 2")
if  (delete_res>0){
    println("delete successful")
    }else {
    println("delete not successful")
    }

//
//update query-update
 val update_res = connection.createStatement().executeUpdate("update users set name = 'shami' where id = 7")
 if(update_res>0){
    println("update successful")
 }else {
     println("update not successful")
 }
//fetch records from database//select query -  Read
 val query = connection.prepareStatement("select * from users")
 val result = query.executeQuery()
 val users = mutableListOf<User>()

 while(result.next()){
    val id = result.getInt("id")
    val name = result.getString("name")
    val age = result.getInt("age")
    val email = result.getString("email")
    val phone = result.getInt("phone")
    val city = result.getString("city")
    val state = result.getString("state")
    val country = result.getString("country")
    val pincode = result.getInt("pincode")
    users.add(User(id,name,age,email,phone,city,state,country,pincode))
 }
 println(users)
 }
