package shape
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var selectedMenu: Int

    do {
        showMenu()
        selectedMenu = getSelectedMenu()
        if (selectedMenu != 7) {
            executeMenu(selectedMenu, getTotalLine(), getReqColor())
        }
    } while (selectedMenu < 7)
    sayGoodBye()
}

private fun showMenu() {
    println("SELAMAT DATANG PREN!! (●'◡'●)")
    println("===========================")
    println("Pilih salah satu bentuk di bawah yang mau ditampilkan")
    println("1. Segitiga\n2. Segitiga Terbalik\n3. Diamond/Berlian")
    println("4. Silang/Cross\n5. Segitiga Tepi\n6. Segitiga Tepi Terbalik\n7. Keluar aja ah")
}

private fun sayGoodBye(){
    println("Thank You! See you, Buddy! ლ(╹◡╹ლ)")
}

private fun getSelectedMenu() : Int {
    var answer: Int

    do {
        print("\nPilihan kamu adalah: ")
        answer = readLine()?.toIntOrNull() ?: 0
    } while (!checkSelectedMenu(answer))

    return answer
}

private fun checkSelectedMenu(answer: Int) : Boolean {
    if(((answer < 1) || (answer > 7))) {
        println("Input salah nih ( ﾉ ﾟｰﾟ)ﾉ\nMohon input dari angka 1-7 aja yak ┌( ಠ_ಠ)┘")
        return false
    }

    return true
}

private fun getTotalLine() : Int {
    var answer: Int

    do {
        println("\nMau cetak berapa baris bro? (Min. 1 baris)")
        print("Pilihan kamu: ")
        answer = readLine()?.toIntOrNull() ?: 0
    } while (!checkTotalLine(answer))

    return answer
}

private fun checkTotalLine(answer: Int) : Boolean {
    if (answer < 1){
        println("Input salah, minimal 1 baris maszeh (╯▔皿▔)╯")
        return false
    }

    return true
}

private fun getReqColor() : String {
    var answer: Int

    do {
        println("\nMau cetak dalam warna apa? (^///^)")
        println("1. Default (putih)\n2. Kuning\n3. Merah\n4. Hijau\n5. Biru")
        print("Pilihan kamu: ")
        answer = readLine()?.toIntOrNull() ?: 0
    } while (!checkReqColor(answer))

    return findColorCode(answer)
}

private fun checkReqColor(answer: Int) : Boolean {
    if ((answer < 1) || (answer > 5)){
        println("Warna yang kamu pilih belum ada di pilihan (´。＿。｀)")
        return false
    }

    return true
}

private fun findColorCode(answer: Int) : String {
    when (answer) {
        1 -> {
            return "\u001B[37m"
        }
        2 -> {
            return "\u001B[33m"
        }
        3 -> {
            return "\u001B[31m"
        }
        4 -> {
            return "\u001B[32m"
        }
        5 -> {
            return "\u001B[34m"
        }
        else -> {
            return "invalid"
        }
    }
}

private fun executeMenu(selectedMenu: Int, totalLine: Int, color: String) {
    println()

    when (selectedMenu) {
        1 -> {
            Triangle(totalLine, color).also {
                it.printShape()
            }
        }
        2 -> {
            Triangle(totalLine, color).also {
                it.printFlipped()
            }
        }
        3 -> {
            Diamond(totalLine, color).also {
                it.printShape()
            }
        }
        4 -> {
            Cross(totalLine, color).also {
                it.printShape()
            }
        }
        5 -> {
            Triangle(totalLine, color).also {
                it.printHollowed()
            }
        }
        6 -> {
            Triangle(totalLine, color).also {
                it.printFlippedHollowed()
            }
        }
    }
    println("\nYay! Bentuk yang dipilih berhasil dicetak! q(≧▽≦q)\n")
}