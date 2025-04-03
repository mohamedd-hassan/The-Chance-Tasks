
fun main(){
    check(
        name = "the numbers when between 0 and 255 should return true",
        result =  isValid("92.168.100.1"),
        correctResult = true
    )
    check(
        name = "the numbers when not between 0 and 255 should return false",
        result =  isValid("92.168.256.1"),
        correctResult = false
    )
    check(
        name = "when given only 3 dots should return true",
        result =  isValid("92.168.100.1"),
        correctResult = true
    )
    check(
        name = "when given less than 3 dots should return false",
        result =  isValid("92.168.100"),
        correctResult = false
    )
    check(
        name = "when given more than 3 dots should return false",
        result =  isValid("92.168.100.1.2"),
        correctResult = false
    )
    check(
        name = "when staring with leading zero unless its zero should return false",
        result =  isValid("92.168.001.0"),
        correctResult = false
    )
    check(
        name = "when the number is zero without being followed by more numbers should return true",
        result =  isValid("92.168.0.1"),
        correctResult = true
    )
    check(
        name = "the number has special characters so it should return false",
        result =  isValid("92.1$8.0.1"),
        correctResult = false
    )
    check(
        name = "the input is not a string so it should return false",
        result =  isValid(192.16801),
        correctResult = false
    )
    check(
        name = "the number is empty so it should return false",
        result =  isValid(""),
        correctResult = false
    )
}


fun check(name: String, result: Boolean, correctResult: Boolean){
    if (result == correctResult){
        println("Success - $name")
    } else{
        println("Failed - $name")
    }
}