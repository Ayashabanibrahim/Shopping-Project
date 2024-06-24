open class UserData(
    var name:String,
    var email:String,
    var password:String,
    var phone:String,
    var address:String )
{
    init{
        id++
    }

    var userId:Int=id
    companion object{
        var id=0
    }
    fun printData()  {
     println("Your Data is:\nName:$name\nEmail:$email \nPhone:$phone\nAddress:$address\nId:$userId")
        println("-----------------------------------------------------------------------------------------------------------------")
    }
}