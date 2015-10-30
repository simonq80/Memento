public class Originator{
		public String data;
		public int xloc;
		public int yloc;
		//create empty originator
		public Originator(){
			this.data = null;
			this.xloc = 0;
			this.yloc = 0;
		}
		//change values
		public void update(String data, int xloc, int yloc){
			this.data = data;
			this.xloc = xloc;
			this.yloc = yloc;
		}
		//create memento from current data
		public Memento create_mem(){
			Memento toReturn = new Memento(data, xloc, yloc);
			return toReturn;
		}
		//Print current data
		public String print_data(){
			return (data + " " + xloc + " " + yloc + "\n");
		}
		//restore values from a given memento
		public void restore_memento(Memento restore){
			this.data = restore.data;
			this.xloc = restore.xloc;
			this.yloc = restore.yloc;
		}
	}
