import kotlin.io.println
import kotlin.io.println as println1

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


var hashOwners= HashMap<Int,Owner>()
var hashOwners2=HashMap<String,Owner>()
var hashClients=HashMap<String,Client>()
var obj=General()

fun listOptionClient(){
    println1("1:All Markets That Available\n2:All Products IN Markets\n3:Shopping")
    println1("4:Search About Determined Market \n5:Add Money In Your Visa\n6:What Money In Visa You Have\n7:Print My Data" +
            "\n8:Delete My Account\n9:Go Back\n10:Finish Program")
    println1("Choose In Range 1:11")
}
fun listOptionOwner(){
    println1("1:Create Market For You\n2:Add Products In Market\n3:Delete Your Market\n4:Print My Markets\n5:Print Products In All Markets")
    println1("6:What Products That It Finished\n7:What Profit You Have\n8:print My Data" +
            "\n9:Delete My Account\n10:Go Back\n11:Finish Program")
    println1("Choose In Range 1:11 ")
}

fun main() {
    println1("********************************************************************'Welcome For You In My Project'********************************************************************")
    var flagToFinish=true
    while (flagToFinish) {
        println1("1:Sing In\n2:Sing Up")
        println1("Choose in Range 1:2")
        val ch: Int = readln().toInt()
        if (ch == 1) {
            println1("1:Owner Of Market")
            println1("2:Client")
            println1("Choose What You Be in Range 1:2")
            val c: Int = readln().toInt()
            if (c == 1) {
                val pass: String = obj.singInAsOwner()
                if(pass!="") {
                    val owner: Owner? = hashOwners2[pass]
                    while (true) {
                        listOptionOwner()
                        val op: Int = readln().toInt()
                        when (op) {
                            1 -> {
                                owner?.createMarket()
                            }

                            2 -> {
                                owner?.addAnotherProducts()
                            }

                            3 -> {
                                owner?.removeMarket()
                            }

                            4 -> {
                                owner?.listOfMarkets()
                            }

                            5 -> {
                                owner?.listOfProducts()
                            }

                            6 -> {
                                owner?.finishedProducts()
                            }

                            7 -> {
                                owner?.myProfit()
                            }

                            8 -> {
                                owner?.printData()
                            }

                            9 -> {
                                obj.removeOwner(owner!!)
                                println("See You Soon..!")
                                break
                            }

                            10 -> {
                                println("See You Soon..!")
                                break
                            }

                            11 -> {
                                flagToFinish = false
                                break
                            }

                            else -> println("Invalid Option..Try Again")
                        }
                    }
                }

            } else if (c == 2) {
                val pass: String = obj.singInAsClient()
                if(pass!="") {
                    val client: Client? = hashClients[pass]
                    while (true) {
                        listOptionClient()
                        val op: Int = readln().toInt()
                        when (op) {
                            1 -> {
                                client?.listOfMarkets()
                            }

                            2 -> {
                                client!!.listOfProducts()
                            }

                            3 -> {
                                client?.buying()
                            }

                            4 -> {
                                client?.searchMarket()
                            }

                            5 -> {
                                client?.addMoney()
                            }

                            6 -> {
                                client?.moneyInVisa()
                            }

                            7 -> {
                                client?.printData()
                            }

                            8 -> {
                                obj.removeClint(client!!)
                                println1("See You Soon..!")
                                break
                            }

                            9 -> {
                                println1("See You Soon..!")
                                break
                            }

                            10 -> {
                                flagToFinish = false
                                break
                            }

                            else -> println("Invalid Option..Try Again")

                        }
                    }
                }
            } else {
                println1("Error!!You Must Choose In Range 1:2 Only..")
            }
        } else if (ch == 2) {
            println1("1:Owner Of Market")
            println1("2:Client")
            println1("Choose What You Want To Be in Range 1:2")
            val c: Int = readln().toInt()
            if (c == 1) {
                val owner = obj.addOwner()
                while (true) {
                    listOptionOwner()
                    val op: Int = readln().toInt()
                    when (op) {
                        1 -> {
                            owner.createMarket()
                        }
                        2 -> {
                            owner.addAnotherProducts()
                        }

                        3 -> {
                             owner.removeMarket()
                        }

                        4 -> {
                            owner.listOfMarkets()
                        }

                        5 -> {
                            owner.listOfProducts()
                        }

                        6 -> {
                            owner.finishedProducts()
                        }

                        7 -> {
                            owner.myProfit()
                        }
                        8 -> {
                            owner.printData()
                        }
                        9 -> {
                            obj.removeOwner(owner)
                            println1("See You Soon..!")
                            break
                        }
                        10 -> {
                            println1("See You Soon..!")
                            break
                        }

                        11 -> {
                            flagToFinish = false
                            break
                        }
                        else -> println("Invalid Option..Try Again")
                    }
                }
            } else if (c == 2) {
                val client = obj.addClient()
                var market = Market()
                while (true) {
                    listOptionClient()
                    val op: Int = readln().toInt()
                    when (op) {
                        1 -> {
                             client.listOfMarkets()
                        }
                        2 -> {
                            client.listOfProducts()
                        }

                        3 -> {
                            client.buying()
                        }

                        4 -> {
                           client.searchMarket()
                        }
                        5 -> {
                            client.addMoney()
                        }
                        6-> {
                            client.moneyInVisa()
                        }
                        7 -> {
                            client.printData()
                        }
                        8 -> {
                            obj.removeClint(client)
                            println1("See You Soon..!")
                            break
                        }
                        9 -> {
                            println1("See You Soon..!")
                            break
                        }

                        10 -> {
                            flagToFinish = false
                            break
                        }
                        else -> println("Invalid Option..Try Again")

                    }
                }
            } else {
                println1("Error!!You Must Choose In Range 1:2 Only..")
            }

        } else {
            println1("Error!!You Must Choose In Range 1:2 Only..")
        }
    }

}
