class Client(
    name1:String,
    email1:String,
    password1:String,
    phone1:String,
    address1:String,
   private var totalMoneyNeedPaid:Int=0,
) :UserData(name1,email1,password1,phone1,address1) ,Base {
   var myVisa = Visa()
    fun moneyInVisa() = println("You Have :${myVisa.totalMoney}$")
    fun addMoney() {
        println("Enter Value:")
        val money:Int= readln().toInt()
        myVisa.totalMoney+=money
    }
   private fun paying() {
        if (myVisa.totalMoney >= totalMoneyNeedPaid) {
            myVisa.totalMoney -= totalMoneyNeedPaid
            totalMoneyNeedPaid=0
            println("The Payment Has Been Completed Successfully..")

        } else {
            while (myVisa.totalMoney < totalMoneyNeedPaid){
            println("Sorry!!..You Can't Pay The Money,Your Money Is Much Less Than The Amount You Want To Pay!!")
            moneyInVisa()
                println("Please,Enter Money In Your Visa To Complement Process..!!")
                addMoney()
            }
            myVisa.totalMoney -= totalMoneyNeedPaid
            totalMoneyNeedPaid=0
            println("The Payment Has Been Completed Successfully..")
        }

    }

    override fun listOfMarkets(){
        var flag = false
        var count = 1
        obj.owners.forEach {
            if (it.markets.isNotEmpty()) {
                it.markets.forEach {
                    println("$count:Market Name: ${it.name} ,Type: ${it.type} ,Owner Id: ${it.ownerId}")
                    count++
                }
                flag = true
            }
        }
        if (!flag) {
            println("Sorry!..Doesn't  Found Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }



    fun buying() {
        var bol=false
        obj.owners.forEach {
            if (it.markets.isNotEmpty()){
                bol=true
            }
        }
        if(bol) {
            println("Please,Enter Name And Owner Id of Market You Want..")
            val name = readln()
            val id: Int = readln().toInt()
            var isFound = false
            var chosenMarket = Market()
            obj.owners.forEach {
                if (it.markets.find { it.ownerId == id && it.name == name } != null) {
                    isFound = true
                    it.markets.forEach {
                        if (it.name == name && it.ownerId == id)
                            chosenMarket = it
                    }
                }
            }
            if (!isFound) {
                println("SORRY..!! The Market You Choose Not Found.")
            } else {
                if (chosenMarket.products.isEmpty()) {
                    println("Sorry,Not Found Any Products In This Market..!!")
                } else {
                    println("Welcome For You In Market $name..!")
                    println("Products IN This market :")

                    chosenMarket.products.forEach {
                        if (it.numberOfProduct != 0) {
                            println("Name Of Product: ${it.name} , Price:${it.price}$ , Available Number :${it.numberOfProduct}")
                        }
                    }

                    var flag = true
                    var total = 0
                    while (flag) {
                        println("Please,Enter Name And Number Of Product You Want Buy It ")
                        val name = readln()
                        val num: Int = readln().toInt()
                        var flag2=false
                        var s="More"
                        chosenMarket.products.forEach {
                            if (it.name == name) {
                                if (num <= it.numberOfProduct) {
                                    it.numberOfProduct -= num
                                    total += (num * it.price)
                                } else {
                                    var n = 0
                                    while (true) {
                                        println("The Number Of Product You Need Is More Than The Available :${it.numberOfProduct}")
                                        println("Please,Enter Another Number But Must Less Than Or Equal to ${it.numberOfProduct}")
                                        n = readln().toInt()
                                        if (n <= it.numberOfProduct) break
                                    }
                                    it.numberOfProduct -= n
                                    total += (num * it.price)
                                }
                                flag2=true
                            }
                            }
                          if(flag2==false) {
                              println("This Product Not Found..!!")
                              s="Another"
                          }
                            println("If You Want To Buying $s Products Press Yes Or No To Not..!")
                            val op = readln()
                            if (op == "No"||op=="no"||op=="nO"||op=="NO") {
                                flag = false
                                println("Thank You For Dealing Whit Us,You Must Pay $total $")
                                totalMoneyNeedPaid += total
                                paying()
                                val owner: Owner? = hashOwners[chosenMarket.ownerId]
                                if (owner != null) owner.totalProfit += total
                            }
                        }
                    }
                }
            }
        else {
            println("Sorry!..Doesn't  Found Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }


          fun searchMarket() {
              var bol=false
              obj.owners.forEach {
                  if (it.markets.isNotEmpty()){
                      bol=true
                  }
              }
              if(bol) {
                  println("Please,Enter Type Of Market You Need It")
                  val type = readln()
                  var s = "This Market Exists"
                  var flag = false
                  obj.owners.forEach {
                      it.markets.forEach {
                          if (it.type == type) {
                              println(" $s,And This Is Some Information About It.")
                              println("Name Of This Market:${it.name} , Owner Id ${it.ownerId}")
                              println("And These Are The Available Products: ")
                              it.products.forEach {
                                  if (it.numberOfProduct != 0) {
                                      println("Name Of Product: ${it.name} , Price:${it.price}$ , Available Number :${it.numberOfProduct}")
                                  }
                              }
                              flag = true
                          }
                          if (flag) s = "There Are Another Market With Same Type"
                      }
                  }
                  if (flag) {
                      println("If You Want To Buying From It Press Yes Or No To Not")
                      val op = readln()
                      if (op == "Yes"||op=="YES"||op=="yes"||op=="yEs"||op=="yeS") {
                          buying()
                      }
                  } else {
                      println("Sorry,This Type Not Available..!!")
                  }
              }else{
                  println("Sorry!..Not Found Any Markets Yes..!!")
              }
              println("-----------------------------------------------------------------------------------------------------------------")
            }

    override fun listOfProducts() {
        var flag = false
        var count = 1
        obj.owners.forEach {
            if (it.markets.isNotEmpty()) {
                it.markets.forEach {
                    var flag2=false
                    println("$count:Market Name: ${it.name} ,Type: ${it.type} ,Owner Id: ${it.ownerId}")
                    it.products.forEach {
                        if (it.numberOfProduct != 0) {
                            println("Name Of Product: ${it.name} , Price:${it.price}$ , Available Number :${it.numberOfProduct}")
                            flag2=true
                        }
                    }
                    if(!flag2) println("Not Found Any Products Yet..!")
                    count++
                }
                flag = true
            }
        }
        if (!flag) {
            println("Sorry!..Doesn't  Found Any Markets Yet..!!")
        }
        println("-----------------------------------------------------------------------------------------------------------------")
    }
}