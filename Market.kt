class Market(
    var name:String="",
    var ownerId:Int=0,
    var type:String="",
    var products:ArrayList<Product> = ArrayList()
) {
    init {
        id++
    }

    companion object{
        var id=0
    }
    var marketId:Int=id
}