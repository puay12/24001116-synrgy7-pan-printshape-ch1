package shape

class Diamond(totalLine: Int, color: String)
        : Shape(totalLine, color) {

        override fun getShape() : ArrayList<String> {
                val newTotalLine = if (this.totalLine % 2 == 0) this.totalLine / 2 else this.totalLine / 2 + 1
                val triangle = Triangle(newTotalLine, this.color)
                var newShape = triangle.getShape()
                newShape.addAll(newShape.reversed())

                return newShape
        }
}