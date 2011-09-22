import java.util.Collection;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class PriorityQueueHeap<E> extends AbstractQueue<E>{
	
	public Object datos[];
	public int tama�o;
	
	/**
	 * Constructor	Permite crear una nueva cola con priorida utilizando un Heap
	 */
	public PriorityQueueHeap(int size){
		datos = (E[]) new Object[size];
		tama�o=0;		
	}
	
	
	public boolean add(E value)throws QueueFullException{
		
		try{
			int pos = tama�o;             // virtual position of value
	        int pPos = (pos - 1) / 2;   // position of parent
	        tama�o++;
	        Comparable<E> compValue = (Comparable<E>) value;
	        while(pos > 0 && compValue.compareTo((E)datos[pPos]) < 0) {
	            datos[pos] = datos[pPos]; // move parent into position
	            pos = pPos;             // and step upward
	            pPos = (pos - 1) / 2;
	        }
	        datos[pos] = value;          // place value in final position
	        return true;
		}catch(Exception ex){
			throw new QueueFullException("La cola esta llena!");
		}
	}
	
	/**
	 * Permite a�adir un elemento a la cola
	 * @return	boolean  Indica si se pudo o no a�adir el elemento
	 */
	public boolean offer(E value){
		int pos = tama�o;             // virtual position of value
        int pPos = (pos - 1) / 2;   // position of parent
        tama�o++;
        Comparable<E> compValue = (Comparable<E>) value;
        while(pos > 0 && compValue.compareTo((E)datos[pPos]) < 0) {
            datos[pos] = datos[pPos]; // move parent into position
            pos = pPos;             // and step upward
            pPos = (pos - 1) / 2;
        }
        datos[pos] = value;          // place value in final position
        return true;
	}
	
	
	/**
	 * Permite obtener y retirar el primer elemento en la cola
	 */
	public E remove(){
		E ret = (E)datos[0];
        tama�o--;                   // move last item to root,
        Comparable<E> toTrickle = (Comparable<E>) datos[tama�o]; // trickle it down
        datos[tama�o] = null;
        int pos = 0;
        while(true) {
            int less = 2 * pos + 1; // determine lesser of children
            if(less >= tama�o) break;
            Comparable<E> left = (Comparable<E>) datos[less];
            if(less + 1 < tama�o && left.compareTo((E)datos[less + 1]) > 0) {
                less++;
            }

           if(toTrickle.compareTo((E)datos[less]) < 0) break;
            datos[pos] = datos[less];
            pos = less;
        }
        datos[pos] = (E) toTrickle;

       return ret;
	}
	
	public E poll(){
		E ret = (E)datos[0];
        tama�o--;                   // move last item to root,
        Comparable<E> toTrickle = (Comparable<E>) datos[tama�o]; // trickle it down
        datos[tama�o] = null;
        int pos = 0;
        while(true) {
            int less = 2 * pos + 1; // determine lesser of children
            if(less >= tama�o) break;
            Comparable<E> left = (Comparable<E>) datos[less];
            if(less + 1 < tama�o && left.compareTo((E)datos[less + 1]) > 0) {
                less++;
            }

           if(toTrickle.compareTo((E)datos[less]) < 0) break;
            datos[pos] = datos[less];
            pos = less;
        }
        datos[pos] =  toTrickle;

       return ret;
		
	}
	
	public E peek(){
		return (E)datos[0];
		 
	}
	
	/**
	 * Permite obtener pero no eliminar el primer elemento en la Cola
	 * @return	Devuelve el primer elemento si la lista no esta vacia, si esta vacia devuelve null.
	 */
	public E element(){
		return this.peek();
	}
	
	public int size(){
		return tama�o;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
