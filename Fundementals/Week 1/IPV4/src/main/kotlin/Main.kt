fun main() {
}

fun isValid(input: Any): Boolean {
    if (input !is String){
        return false
    }
    val segments = input.split(".").toList()
    if (segments.size != 4){
        return false
    }
    for (i in segments){
        if (i.length != 1 && i[0] == '0'){
            return false
        }
        val x = i.toIntOrNull()
        if (x != null) {
            if (x < 0 || x > 255){
                return false
            }
        } else{
            return false
        }
    }
    return true
}