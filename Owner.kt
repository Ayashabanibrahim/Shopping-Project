@Suppress("UNREACHABLE_CODE")
class Owner (
    name1:String,
    email1:String,
    password1:String,
    phone1:String,
    address1:String,
    var totalProfit:Int=0,
):UserData(name1,email1,password1,phone1,address1),Base {
    var markets: ArrayList<Market> = ArrayList()
    fun removeMarket()  {
        if (markets.isEmpty() == true) println("You Don't Have Any Market To Delete It..!")
        else {
            println("Enter Name Of Market You Want Delete It")
            val name = readln()
            var flag = false
            var market=Market()
            markets.forEach {
                if (it.name == name) {
                     market=it
                    flag = true
                }
            }
            if (flag) {
                markets.remove(market)
                println("The Market Has Been Successfully Deleted.")
            }
            else println("Sorry,This Market Not Found To delete It..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }
    fun myProfit() = println("Your Total Profit :$totalProfit")

    override fun listOfMarkets() {
        if (markets.isNotEmpty()) {
            var count = 1
            markets.forEach {
                println("$count:Market Name ${it.name} ,Type:${it.type}")
                count++
            }
        } else {
            println("Sorry You Not Have Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }

    override fun listOfProducts() {
        if (markets.isNotEmpty()) {
            markets.forEach {
                val nam: String = it.name
                println("Products In Market $nam Are:")
                if (it.products.isNotEmpty()) {
                    var flag = false
                    it.products.forEach {
                        if (it.numberOfProduct != 0) {
                            println("Product:${it.name} ,Price :${it.price} ,Number Of Product :${it.numberOfProduct}")
                            flag = true
                        }
                    }
                    if (!flag) {
                        println("Sorry You Not Have Any Products In Your Market $nam Yet..!!")
                    }
                }
            }
        } else {
            println("Sorry You Not Have Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }

    fun finishedProducts() {
        if (markets.isNotEmpty()) {
            markets.forEach {
                val nam: String = it.name
                println("Finished  Products In Market $nam Are:")
                if (it.products.isNotEmpty()) {
                    var flag = false
                    it.products.forEach {
                        if (it.numberOfProduct == 0) {
                            println("${it.name} ")
                            flag = true
                        }
                    }
                    if (!flag) println("Not Found Any Finished Products..!")
                } else {
                    println("Sorry You Not Have Any Products In Your Market $nam Yet..!!")
                }
            }
        } else {
            println("Sorry You Not Have Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")

    }

    fun createMarket() {
        var op = true
        println("Welcome For You,Follow It To Create Your New Market")
        while (op) {
            print("Enter Name Of Market: ")
            var nam: String = readln()
           while( markets.find { it.name==nam }!=null) {
               println("Please,Enter Another Name To Your Market..This Name Is Already Taken!!")
               nam= readln()
           }
            print("Enter Type Of Market: ")
            val typ: String = readln()
            println("Enter Products Of Market ")
            var flag = true
            val myproducts: ArrayList<Product> = ArrayList()

            while (flag) {
                print("Enter Name Of Product: ")
                val nam1: String = readln()
                var flag2=false
                markets.forEach {
                    if(it.products.find { it.name==nam1 }!=null){
                        flag2=true
                    }
                }
                if(myproducts.find { it.name==nam1 }!=null||flag2 ){
                    println("This Product Is Found..!!")
                }
                else {
                    print("Enter Price Of Product: ")
                    val price: Int = readln().toInt()
                    print("Enter Number  Of Products: ")
                    val num: Int = readln().toInt()
                    val prod1 = Product(nam1, price, num)
                    myproducts.add(prod1)
                }
                print("If You Need To Enter Another Product Pass Yes Or No To Not : ")
                val option: String = readln()
                if (option == "No"||option=="no"||option=="nO"||option=="NO") flag = false
            }
            val mrk1 = Market(nam, userId, typ, myproducts)
            markets.add(mrk1)

            print("If You Need To Create Another Market Pass Yes Or No To Not : ")
            val option: String = readln()
            if (option == "No"||option=="no"||option=="nO"||option=="NO") op = false
        }
       println("----------------------------------------------------------------------------------------------------------------")
    }

    fun addAnotherProducts() {
        if (markets.isNotEmpty()) {
            var flag = true
            var bol = false
            println("Enter Name Of Market:")
            val name = readln()
            var market: Market = Market()
            markets.forEach {
                if (it.name == name) {
                    market = it
                    bol = true
                }
            }
            if (bol) {
                while (flag) {
                    print("Enter Name Of Product: ")
                    val nam1: String = readln()
                    var flag2 = false
                    markets.forEach {
                        if (it.products.find { it.name == nam1 } != null) {
                            flag2 = true
                        }
                    }
                    if ( flag2) {
                        println("This Product Is Found..!!")
                    } else {
                        print("Enter Price Of Product: ")
                        val price: Int = readln().toInt()
                        print("Enter Number  Of Products: ")
                        val num: Int = readln().toInt()
                        val prod1 = Product(nam1, price, num)
                        market.products.add(prod1)
                    }
                        print("If You Need To Enter Another Product Pass Yes Or No To Not : ")
                        val option: String = readln()
                        if (option == "No" || option == "no" || option == "nO" || option == "NO") flag = false
                }
            } else {
                println("This Market Is Not Found..!!")
            }

        } else {
            println("Sorry You Not Have Any Markets Yet..!!")
        }
        println("------------------------------------------------------------------------------------------------------------------")
    }
}