//Question 1
// the main differences are that on stacks the first data that enters the stack is the last data retrieved(popped) from it, however, in queues, the first data that enters the queue is the first that leaves it;

//Question 2
// when the size of the data you want to use is not clearly defined

//Question 3
// the number of collisions in a hash table occurs when the hash function returns two keys to the same slot(memory address) on the hash table;

//Question 4
public boolean isOdd(int number){
	if (number == 0) {
		return true;
	} else if (number == 1 || number == -1){
		return false;
	} else if (number > 0) {
		return isOdd(number - 2);
	} else {
		return isOdd(number + 2);
	}
}


//Question 5

import java.util.Arrays;
public boolean isProperlyNested(String testString){
	if ("".equals(testString)){
		return true;
	} 
	final Stack<char> stack = new Stack<>();
	for(char c : Arrays.asList(testString.toCharArray)){
		switch (c){
			case '{':
			case '[':
			case '(':
				stack.push(c);
			break;
			case '}':
				if (!stack.peek() == '{'){
					return false;
				} else {
					stack.pop();
				}
			break;
			case ']':
				if (!stack.peek() == '['){
					return false;
				} else {
					stack.pop();
				}
			break;
			case ')':
				if (!stack.peek() == '('){
					return false;
				} else {
					stack.pop();
				}
			break;
			default:
				throw new Exception("Unsupported Character");
			break;
		}
	}
	return stack.empty();
}

//Question 6
public Integer maxCountOfZerosInsideBinaryRepresentationOfANumber(Integer number){
	return dfs(number.toBinaryString(), -99999999, 0, false);
}

public Integer dfs(String digits, Integer max, Integer currentCount, boolean isOpen){
	if (digits.length > 1){
		if (digits.charAt(0) == '1' && isOpen == false){
			return dfs(digits.substring(1), max, 0, true);
		} else if ((digits.charAt(0) == '1' && isOpen == true)){
			if (currentCount > max){
				max = currentCount;
				return dfs(digits.substring(1), max, 0, false);
			}
		} else {
			return dfs(digits.substring(1), max, currentCount++, true);
		}
	} else {
		if ((digits.charAt(0) == '1' && isOpen == true && currentCount > max){
			return currentCount;
		}
	}
	return max;
}

//Question 7
public int bitwiseAndOfRange(int min, int max){
	int result = min;
	for (int i = min; i < max; i++){
		result = result & (min + 1);
	}
	return result;
}

//Question 8
public int[] arrayRotation(int[] array, int rotation){
	final List<int> list = Arrays.asList(array);
	Collections.rotate(list, rotation);
	return list.toArray();
}