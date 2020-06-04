package com.techblog.Exceptions;

@SuppressWarnings("serial")
public class FolderNotFoundException extends Exception{

	public FolderNotFoundException()
	{
		super("Folder Not Found");
	}
}
