//fun twoSum(nums: IntArray, target: Int): IntArray? {
//    val map: MutableMap<Int, Int> = HashMap()
//    for (i in nums.indices) {
//        map[nums[i]] = i
//
//    }
//    for (i in nums.indices) {
//        val complement = target - nums[i]
//        if (map.containsKey(complement) && map[complement] != i) {
//            return intArrayOf(i, map[complement]!!)
//        }
//    }
//    throw IllegalArgumentException("No two sum solution")
//}

fun main() {

    startGame()

//    val a = listOf(1, 2 , 4, 5);
//    val b = listOf(4, 5, 8, 11, 1, 7);
////    println(findIndices(a, 100))
//    println(findIndices(b, 9))
}


fun findIndices(nums: List<Int>, target: Int): List<Int> {
    if (nums.size < 2) return listOf() // if the array contains 1 or no values

    var foundPair = false
    var pointer = 0
    var result = mutableListOf<Int>()

    while (!foundPair) {
        for ((idx, value) in nums.withIndex()) {
            if (nums[pointer] + value == target) {
                result = mutableListOf(pointer, idx)
                foundPair = !foundPair
            } else {
                pointer += 1 // move the pointer to the next index
            }
            break
        }
        if (foundPair || pointer >= nums.lastIndex) break
    }
    return result
}