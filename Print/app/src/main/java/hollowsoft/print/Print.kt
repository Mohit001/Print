package hollowsoft.print

import android.graphics.Bitmap
import android.view.View

/**
 * @author Igor Morais
 */
class Print {

    fun print(view: View) : Bitmap {

        view.isDrawingCacheEnabled = true

        view.buildDrawingCache()

        val bitmap = Bitmap.createBitmap(view.drawingCache)

        view.isDrawingCacheEnabled = false

        return bitmap
    }
}
