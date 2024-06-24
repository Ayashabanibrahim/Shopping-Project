class General {
    var owners: ArrayList<Owner> =ArrayList()
     var clients: ArrayList<Client> =ArrayList()
    fun removeOwner(owner: Owner) {
        hashOwners2.remove(owner.password)
        obj.owners.remove(owner)
        println("-----------------------------------------------------------------------------------------------------------------")
    }
    fun removeClint(client: Client)
        {
        hashClients.remove(client.password)
            obj.clients.remove(client)
            println("-----------------------------------------------------------------------------------------------------------------")
        }
    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
        return emailRegex.matches(email)
    }
    fun addOwner():Owner {
        print("Enter Your Name: ")
        val name: String = readln()
        print("Enter Your Password: ")
        var pass: String = readln()
        while (hashOwners2[pass]!=null||hashClients[pass]!=null)
        {
            println("Please,Enter Another Password ,It Is Already Taken!!")
            pass= readln()
        }
        print("Enter Your Email: ")
        var email: String = readln()
        while(!isValidEmail(email)){
            println("Incorrect Email..Try Again!!")
            email= readln()
        }
        print("Enter Your Phone: ")
        val phone: String = readln()
        print("Enter Your address: ")
        val address: String = readln()
        println("Welcome for You,Now You have Account As Owner Of Markets")
        val newOwner = Owner(name, email, pass, phone, address)
        owners.add(newOwner)
        hashOwners[newOwner.userId]=newOwner
        hashOwners2[pass]=newOwner
        println("-----------------------------------------------------------------------------------------------------------------")
        return newOwner
    }

    fun addClient():Client {
        print("Enter Your Name: ")
        val name: String = readln()
        print("Enter Your Password: ")
        var pass: String = readln()
        while (obj.owners.find { it.password==pass }!=null||obj.clients.find { it.password==pass }!=null)
        //while (hashOwners2[pass]!=null&&hashClients[pass]!=null)
        {
            println("Please,Enter Another Password It Is Already Taken!!")
            pass= readln()
        }
        print("Enter Your Email: ")
        var email: String = readln()
        while(!isValidEmail(email)){
          println("Incorrect Email..Try Again!!")
            email= readln()
        }
        print("Enter Your Phone: ")
        val phone: String = readln()
        print("Enter Your address: ")
        val address: String = readln()
        println("Enter Initial Value Of Money In Your Visa")
        val money:Int= readln().toInt()
        println("Welcome for You,Now You have Account As Client ")
        val newClient = Client(name, email, pass, phone, address)
        newClient.myVisa.totalMoney+=money
        clients.add(newClient)
        hashClients[pass]=newClient
        println("-----------------------------------------------------------------------------------------------------------------")
        return newClient
    }

    fun singInAsOwner() :String {
        print("Enter Your Name: ")
        var name: String = readln()
        while(owners.find { it.name==name }==null&&name!="-1") {
            println("This Name Not Found,Try Again Please..")
            println("Or Enter -1 To Exit")
            name= readln()
        }
        var pass = ""
        if(name!="-1") {
            var op = true
            var s = "Enter Your Password: "
            while (op) {
                print(s)
                pass = readln()
                if (owners.find { it.password == pass } != null) {
                    println("Welcome For You...!")
                    op = false
                } else {
                    println("Sorry!!..You Press An Incorrect Password..!")
                    s = "Please,Enter Correct Password .."
                }
            }
        }
        if(pass=="") println("See You Soon..!")
        println("-----------------------------------------------------------------------------------------------------------------")
            return pass

    }
        fun singInAsClient():String {
            print("Enter Your Name: ")
            var name: String = readln()
            while(owners.find { it.name==name }==null&&name!="-1") {
                println("This Name Not Found,Try Again Please..")
                println("Or Enter -1 To Exit")
                name= readln()
            }
            var pass = ""
            if(name!="-1") {
                var op = true
                var s = "Enter Your Password: "
                while (op) {
                    print(s)
                    pass = readln()
                    if (clients.find { it.password == pass } != null) {
                        println("Welcome For You...!")
                        op = false
                    } else {
                        println("Sorry!!..You Press An Incorrect Password..!")
                        s = "Please,Enter Correct Password .."
                    }
                }
            }
            if(pass=="") println("See You Soon..!")
            println("-----------------------------------------------------------------------------------------------------------------")
            return pass
        }


}