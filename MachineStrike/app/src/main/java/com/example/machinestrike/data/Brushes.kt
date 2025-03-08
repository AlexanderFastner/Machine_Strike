package com.example.machinestrike.data


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.runtime.remember

class Brushes(
    private val corrupt: ImageBitmap,
    private val chasm: ImageBitmap,
    private val grass: ImageBitmap,
    private val forrest: ImageBitmap,
    private val hills: ImageBitmap,
    private val mountain: ImageBitmap
) {
    @Composable
    fun corruptBrush(): ShaderBrush {
        return remember(corrupt) {
            ShaderBrush(
                shader = ImageShader(
                    image = corrupt,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }

    @Composable
    fun chasmBrush(): ShaderBrush {
        return remember(chasm) {
            ShaderBrush(
                shader = ImageShader(
                    image = chasm,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }

    @Composable
    fun grassBrush(): ShaderBrush {
        return remember(grass) {
            ShaderBrush(
                shader = ImageShader(
                    image = grass,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }

    @Composable
    fun forrestBrush(): ShaderBrush {
        return remember(forrest) {
            ShaderBrush(
                shader = ImageShader(
                    image = forrest,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }

    @Composable
    fun hillsBrush(): ShaderBrush {
        return remember(hills) {
            ShaderBrush(
                shader = ImageShader(
                    image = hills,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }

    @Composable
    fun mountainBrush(): ShaderBrush {
        return remember(mountain) {
            ShaderBrush(
                shader = ImageShader(
                    image = mountain,
                    tileModeX = TileMode.Repeated,
                    tileModeY = TileMode.Repeated
                )
            )
        }
    }
}