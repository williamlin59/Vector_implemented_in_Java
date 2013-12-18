/**This is a class that implement the vector algorithm into java by using genesics. 
 * 
 * @author william
 *
 */

public class ArrayVector<E> implements Vector<E>{
	protected int n=0;	//the length of vector
	protected E A[];	//the array that implement the vector
	protected int N;		//the length of array
	/**This is the constructor of the class
	 * 
	 * @param arrayLength is the length of the array.
	 */
	public ArrayVector(int arrayLength){
		N=arrayLength;	//initialize N
		A=(E[]) new Object[N];	//initialize the length of array A and casting it to genersic type E
	}
	@Override
	/**This is a method that return the size of the vector
	 * 
	 */
	public int size() {
		return n;	//return the size n.
	}

	@Override
	/**This is a method that check if the vector is empty or not.
	 * 
	 */
	public boolean isEmpty() {
		if(n==0){
			return true;	//if it's empty, it returns true
		}
		else{
			return false;	//if it's not empty, it returns false
		}
	}

	@Override
	/**This is the method that returns the element in the vector in a certain rank
	 * 
	 *  @param rank the rank that you want to check value it contains
	 */
	public E elemAtRank(int rank) throws RankOutOfBoundsException {
		if(rank<0||rank>n){//if rank<0 or rank>length of vector
			RankOutOfBoundsException exception=new RankOutOfBoundsException("Rank out of bounds");
			throw exception;//throw the exception
		}
		else{
			return A[rank];//if rank is between 0 and n. then return A[rank].
		}
	}
	/**This is a method that replace the Object stored at a certain rank by another specific object
	 *@param rank the rank that you want to replace the value it stores
	 *@param element that wants to replace to
	 * 
	 */
	public E replaceAtRank(int rank, E element)
			throws RankOutOfBoundsException {
		E temp=(E)new Object();//variable temp with genersic type E hold the old value which will be replaced by element soon.
		if(rank<0||rank>n){//if rank<0 or rank>length of vector
			RankOutOfBoundsException exception=new RankOutOfBoundsException("Rank out of bounds");
			throw exception;//throw the exception
		}
		else{
			temp=A[rank];
			A[rank]=element;//if rank is between 0 and n. assign element to A[rank].
		}
		return temp;//return temp
	}
	
	/** This is a method that insert a variable at a specific rank.
	 * @param rank the rank that you want to replace the value it stores
	 * @param element that wants to replace to
	 */
	public void insertAtRank(int rank, E element)
			throws RankOutOfBoundsException {
			if(rank<0||rank>n){//if rank<0 or rank>length of vector
				RankOutOfBoundsException exception=new RankOutOfBoundsException("Rank out of bounds");
				throw exception;//throw the exception
			}
			else if(n==N){//if the vector length reaches the length of array
				N=N*2;//double the number of array length
				Object B[]=new Object[N];//Declare a new array with length 2N as a bridge to link the old array and new array.
				System.arraycopy(A, 0, B, 0, A.length);//copy all the elements from old array to new array.
				A=(E[]) new Object[N];//Assign the array A with new length N and casting it to Genersic type E.
				for(int i=n;i>rank;i--){//from rank-1 to n;
					B[i]=B[i-1];//assign B[i-1] to B[i];
				}
				B[rank]=element;//assign object element to B[rank] 
				n++;//increment of the size of vector
				System.arraycopy(B, 0, A, 0, N);//copy the array back to array A.
			}
			else{
				for(int i=n;i>rank;i--){//from rank-1 to n;
					A[i]=A[i-1];//assign A[i-1] to A[i];
				}
				A[rank]= element;//assign object element to A[rank] 
				n++;//increment of the size of vector
			}
		}
	/**This method remove an element at a certain rank
	 *@param rank the rank that you want to replace the value it stores 
	 */
	@Override
	public E removeAtRank(int rank) throws RankOutOfBoundsException {
		if(rank<0||rank>n){//if rank<0 or rank>length of vector
			RankOutOfBoundsException exception=new RankOutOfBoundsException("Rank out of bounds");
			throw exception;//throw the exception
		}
		else{
			for(int i=rank;i<n-1;i++){//from rank to n-2;
				A[i]=A[i+1];//assign A[i+1] to A[i];
			}
			A[n-1]=null;//assign A[n-1] as null
			n--;//decrement of the size of vector
		}
		return null;
	}
	/**this method print out all the elements from array A.
	 * 
	 */
	public void printout(){
		for(int i=0;i<n;i++){
			System.out.println(A[i]);
		}
	}
}
