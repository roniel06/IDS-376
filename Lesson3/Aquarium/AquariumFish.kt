package example.myapp

interface FishAction  {
    fun eat()
}
interface FishColor {
    val color: String
}
class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor


class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish or other animals hahaha!!")
    }
}
object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
