//nw9ca Inheritance In-class act.
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Set;

	public class MyNewSet<T> extends ArrayList<T> implements Set<T> {
		//The red line disappears after adding 'extends ArrayList<T>' because
		//The class became the subclass of ArrayList that implements Set
		public MyNewSet(){
			super();
		}
		
		@Override
		public boolean add(T o){
			if(this.contains(o)){
				return false;
			}
			super.add(o);
			return true;
		}
		
		@Override
		public boolean addAll(Collection<? extends T> c){
			int i = 0;
			for(T ele: c){
				this.add(ele);
				if(this.add(ele)){
					i += 1;
				}
			}
			if(i > 0){
				return true;
			}
			return false;
		}
		
			
		public static void main(String[] args) {
			 MyNewSet<String> test = new  MyNewSet<String>();
			 String h = "Hello";
			 String n = "Hey";
			 String i = "Hello"; 
			 test.add(h);
			 test.add(n);
			 test.add(i);
			 
			 System.out.println(test);
			 //[Hello, Hey]
			 
			 ArrayList<String> list = new ArrayList<String>();
			 list.add("Goodbye");
			 list.add("Hey");
			 
			 test.addAll(list);
			 System.out.println(test);
			 //[Hello, Hey, Goodbye, Hey] -> not as expected
			 //After Override: [Hello, Hey, Goodbye] -> expected
		}
		
	}

	