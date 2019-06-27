package eduardo.poo.biblioteca

import android.app.AlertDialog
import android.content.Context

class Components {
    companion object{
        fun Alert(context : Context, title :String, message :String) :AlertDialog
        {
            val alert =
                AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton("Entendi"){ dialog, _ -> dialog.dismiss() }
                .create()

            return alert
        }

    }
}