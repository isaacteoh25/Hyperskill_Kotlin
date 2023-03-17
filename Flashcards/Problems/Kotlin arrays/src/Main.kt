fun main(){
//    val inputArray = arrayOf(
//        arrayOf(1, 2, 3),
//        arrayOf(4, 5, 6),
//        arrayOf(7, 8, 9),
//        arrayOf(10, 11, 12)
//    )
//    print(inputArray[2].joinToString())
    val inputArray = arrayOf(
        arrayOf('P', 'R', 'O', 'G', 'R', 'A', 'M', 'M', 'I', 'N', 'G'),
        arrayOf('I', 'S'),
        arrayOf('M', 'A', 'G', 'I', 'C')
    )

    val array2 = arrayOf(
        inputArray.last(),
        inputArray.first()
    )
    print(array2.contentDeepToString())
}

//print(inputArray[2].joinToString())