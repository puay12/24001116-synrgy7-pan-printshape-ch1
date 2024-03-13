package shape

class Cross(totalLine: Int, color: String)
    : Shape(totalLine, color) {

    override fun getShape() : ArrayList<String> {
        val maxStars = this.totalLine + 1
        var newShape = ArrayList<String>()
        var printStart = 2
        var printEnd = maxStars - 1

        for (i in 1..this.totalLine) {
            var stars = ""
            for (j in 1..maxStars) {
                if ((j == printStart) || (j == printEnd)) {
                    stars+="*"
                } else {
                    stars+=" "
                }
            }
            newShape.add(stars)
            printStart += 1
            printEnd -= 1
        }

        return newShape
    }
}