package hollowsoft.print

import android.graphics.Bitmap
import android.view.View
import java.io.File
import java.io.FileOutputStream

/**
 * @author Igor Morais
 */
class Print {

    companion object {

        val QUALITY = 100

        private fun print(view: View) : Bitmap {

            view.isDrawingCacheEnabled = true

            view.buildDrawingCache()

            val value = Bitmap.createBitmap(view.drawingCache)

            view.isDrawingCacheEnabled = false

            return value
        }

        fun print(view: View, layout: Boolean = false) : Bitmap {

            if (layout) {

                view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

                view.layout(0, 0, view.measuredWidth, view.measuredHeight)
            }

            return print(view)
        }

        fun print(name: String, path: String, view: View, layout: Boolean = false) : String {

            val value = print(view, layout)

            val stream = FileOutputStream(File(path + File.separator + name))

            value.compress(Bitmap.CompressFormat.PNG, QUALITY, stream)

            stream.flush()

            return path + File.separator + name
        }
    }
}
