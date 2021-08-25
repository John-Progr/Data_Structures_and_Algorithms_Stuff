import java.io.*;

public class TagMatching {
	private File f;
	private BufferedReader reader;
	private StringStackImpl<String> tags;
	private String line;
	private boolean result = true;

	public TagMatching(String file) {
		//open the file
		try {
			f = new File(file);
		} catch (NullPointerException e) {
			System.err.println("File not found!");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
		}
		tags = new StringStackImpl<String>();
		//stores tags from each line to the stack
		try {
			line = reader.readLine();
			while (line != null && result) { //result == false when we have a wrong pair of tags
										  //so we don't need to check the rest lines
				if (!line.trim().equals("") && line.indexOf("<") != -1 && line.indexOf(">") != -1) {
					//finds all tags in each line and pushes in stack tags
					int leftTag = -1,rightTag = 0;
					while (rightTag < line.length()-1) {
						leftTag = line.indexOf("<",leftTag)+1;
						rightTag = line.indexOf(">",rightTag+1);
						//it checks if there is no tags in the line
						if (leftTag == -1 || rightTag == -1) {
							break;
						}
						String tag = line.substring(leftTag,rightTag).toUpperCase();
						if (!tag.startsWith("/")) {
							tags.push(tag);
						} else {
							if (!tags.isEmpty()) {
								if(!tag.equals("/" + tags.pop())) {
									result = false; //for example tags.pop() == <a> and tag == </b>
								}
							} else {
								result = false; //when the pairs are like </tag> ... <tag>
							}
						}
					}
				}
				line = reader.readLine();
			}
			if (!tags.isEmpty()) {
				result = false;
			}
		} catch (IOException e) {
			System.out.println("Error reading line!");
		}
		//close the file
		try {
            reader.close();
      	} catch (IOException e) {
            System.err.println("Error closing file.");
      	}
	}

	public boolean getResult() {
		return this.result;
	}

	public static void main(String args[]) {
		System.out.println("The html file has pairs tags: " + new TagMatching(args[0]).getResult());
	}
}