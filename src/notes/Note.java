package notes;

import java.util.List;

import com.evernote.auth.*;
import com.evernote.clients.*;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.type.Notebook;
import com.evernote.thrift.TException;

public class Note {
	public static void main(String[] args) throws EDAMUserException, EDAMSystemException,
			TException {
		// TODO: Get developerToken from config file, don't hardcode it
		String developerToken = "...";
		// Set up the NoteStore client
		EvernoteAuth evernoteAuth = new EvernoteAuth(EvernoteService.SANDBOX,
				developerToken);
		ClientFactory factory = new ClientFactory(evernoteAuth);
		NoteStoreClient noteStore = factory.createNoteStoreClient();

		// Make API calls, passing the developer token as the
		// authenticationToken param
		List<Notebook> notebooks = noteStore.listNotebooks();

		for (Notebook notebook : notebooks) {
			System.out.println("Notebook: " + notebook.getName());
		}
	}
}
