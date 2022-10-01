package com.abhishek.notesapp.ui.navigation


interface NotesDestination{
    val route:String
}

object LauncherDestination : NotesDestination{
    override val route: String
        get() = "splash"

}

object LoginDestination : NotesDestination{
    override val route: String
        get() = "login"

}

object SignupDestination : NotesDestination{
    override val route: String
        get() = "signup"

}

object NotesListDestination : NotesDestination{
    override val route: String
        get() = "notesList"

}

object AddNotesDestination : NotesDestination{
    override val route: String
        get() = "addNotes"

}

