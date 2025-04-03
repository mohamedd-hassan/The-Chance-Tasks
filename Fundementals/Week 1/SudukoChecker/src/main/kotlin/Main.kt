import kotlin.math.sqrt

fun main() {
    isValidSudoku(
        listOf(
            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-'),

            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-'),

            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-'),
            listOf('-','-','-', '-','-','-', '-','-','-')
        )
    )
}

fun isValidSudoku(
    puzzle: List<List<Any>>
): Boolean {

    if (!areCharactersValid(puzzle)){
        return false
    }

    if (!isColumnEqualRows(puzzle)){
        return false
    }

    if (isEmpty(puzzle)){
        return false
    }

    val subBoxSize = getSubBoxSize(puzzle)

    if (didRepeatInRow(puzzle)){
        return false
    }
    if (didRepeatInColumn(puzzle)){
        return false
    }
    return !didRepeatInGrid(puzzle, subBoxSize)
}

fun isEmpty(
    puzzle: List<List<Any>>
): Boolean{
    for (i in puzzle){
        for (x in i){
            if (x.toString() != "-"){
                return false
            }
        }
    }
    return true
}

fun areCharactersValid(puzzle: List<List<Any>>): Boolean{
    for (i in puzzle){
        for(x in i){
            if (x.toString() != "-"){
                if (x.toString().toIntOrNull() == null){
                    return false
                }
            }
        }
    }
    return true
}

fun isColumnEqualRows(
    puzzle: List<List<Any>>
): Boolean{
    val columns = puzzle.size
    for (i in puzzle){
        if (i.size != columns){
            return false
        }
    }
    return true
}

fun getSubBoxSize(
    puzzle: List<List<Any>>
): Int{
    return sqrt(puzzle.size.toDouble()).toInt()
}

fun didRepeatInList(
    list: List<Any>
): Boolean{
    val seen = mutableListOf<Int>()
    for (i in list){
        val x = i.toString().toIntOrNull()
        if (x != null){
            if (x !in seen){
                seen.add(x)
            }else{
                return true
            }
        }
    }
    return false
}

fun getColumn(
    puzzle: List<List<Any>>,
    col: Int
): List<String>{
    val column = mutableListOf<String>()
    for (i in puzzle.indices){
        column.add(i, puzzle[i][col].toString())
    }
    return column
}

fun didRepeatInColumn(
    puzzle: List<List<Any>>
): Boolean{
    for (i in 0..puzzle.size){
        return didRepeatInList(getColumn(puzzle, i))
    }
    return false
}

fun didRepeatInRow(
    puzzle: List<List<Any>>
): Boolean{

    for (i in puzzle){
        if (didRepeatInList(i)){
            return true
        }
    }

    return false
}

fun didRepeatInGrid(
    puzzle: List<List<Any>>,
    boxSize: Int
): Boolean{
    for (i in 0 until  boxSize step boxSize){
        for(j in 0 until boxSize step boxSize){
            val box = mutableListOf<String>()
            for (k in i until  i+boxSize){
                for (l in j until  j+boxSize){
                    box.add(puzzle[k][l].toString())
                }
            }
            return didRepeatInList(box)
        }
    }
    return false
}