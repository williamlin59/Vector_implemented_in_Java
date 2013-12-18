/**
 * This is the interface of the Vector ADT as is outlined in the course notes
 *
 * @author Rem Collier
 */
public interface Vector<E> {
	public int size();
	public boolean isEmpty();

	public E elemAtRank(int rank) throws RankOutOfBoundsException;
    public E replaceAtRank(int rank, E element) throws RankOutOfBoundsException;
    public void insertAtRank(int rank, E element) throws RankOutOfBoundsException;
	public E removeAtRank(int rank) throws RankOutOfBoundsException;
}
