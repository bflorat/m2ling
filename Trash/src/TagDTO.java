/**
 * Copyright (C) Bertrand Florat
 */


/**
 * Tag DTO object used between layers.
 * 
 * @author bflorat
 */
public class TagDTO {

	private final String text;

	TagDTO(final String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

}
