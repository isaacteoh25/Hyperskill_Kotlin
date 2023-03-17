val numbers = with(IntArray(100)) { set(0, 1); set(9, 10); set(99, 100); return@with this }

var numbers = IntArray(100)
numbers[0] = 1
numbers[9] = 10
numbers[numbers.lastIndex] = 100
numbers[numbers.size -1] = first

val swap = numbers.first()
numbers[0] = numbers.last()
numbers[numbers.lastIndex] = swap

numbers[0]= numbers[numbers.lastIndex].also { numbers[numbers.lastIndex] = numbers[0] }