package shape

abstract class Shape(
    protected val totalLine : Int = 8,
    protected val color : String = "\u001B[37m"
) {
    abstract fun getShape() : ArrayList<String>

    open fun printShape() {
        val shape = getShape()

        shape.forEach {
            println(this.color + it + "\u001B[0m")
        }
    }

    open fun printShape(shape: List<String>) {
        shape.forEach {
            println(this.color + it + "\u001B[0m")
        }
    }
}