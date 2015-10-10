public class Originator{
		public String data;
		public int xloc;
		public int yloc;
		
		public Originator(){
			this.data = null;
			this.xloc = 0;
			this.yloc = 0;
		}
		public void update(String data, int xloc, int yloc){
			this.data = data;
			this.xloc = xloc;
			this.yloc = yloc;
		}
		public Memento create_mem(){
			Memento toReturn = new Memento(data, xloc, yloc);
			return toReturn;
		}
		
		public void print_data(){
			System.out.print("Current Originator Data: " + data + " " + xloc + " " + yloc + "\n");
		}
		public void restore_memento(Memento restore){
			this.data = restore.data;
			this.xloc = restore.xloc;
			this.yloc = restore.yloc;
		}
	}
