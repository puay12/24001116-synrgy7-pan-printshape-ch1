package shape

class Triangle(totalLine: Int, color: String)
    : Shape(totalLine, color) {

    open override fun getShape() : ArrayList<String> {
        val maxStars = this.totalLine * 2 - 1
        var shape = ArrayList<String>()

        for (x in 1..this.totalLine) {
            var stars = ""
            for (y in 1..maxStars) {
                if ((y > (this.totalLine - x)) && (y < (this.totalLine + x))) {
                    stars += "*"
                } else {
                    stars += " "
                }
            }
            shape.add(stars)
        }

        return shape
    }

    private fun getHollowedShape() : ArrayList<String> {
        val maxStars = this.totalLine * 2
        var newShape = ArrayList<String>()

        for (i in 1..this.totalLine) {
            var stars = ""
            for (j in 1..maxStars) {
                if (i < this.totalLine) {
                    if ((j == (this.totalLine - i + 1)) || (j == (this.totalLine + i - 1))) {
                        stars += "*"
                    } else {
                        stars += " "
                    }
                }
                else {
                    if (j % 2 != 0) {
                        stars += "*"
                    } else {
                        stars += " "
                    }
                }
            }
            newShape.add(stars)
        }

        return newShape
    }

    fun printFlipped() {
        printShape(getShape().reversed())
    }

    fun printHollowed() {
        printShape(getHollowedShape())
    }

    fun printFlippedHollowed() {
        printShape(getHollowedShape().reversed())
    }
}