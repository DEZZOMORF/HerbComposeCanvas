package org.dezzomorf.herb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.dezzomorf.herb.ui.theme.HerbTheme
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HerbTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    EmblemWithShield(
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Flag(
    modifier: Modifier = Modifier
) {
    val blue = Color(0xFF0057B7)
    val yellow = Color(0xFFFFDD00)
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val width = size.width
        val height = size.height

        drawRect(
            color = blue,
            topLeft = Offset(0f, 0f),
            size = Size(width, height.times(0.5f))
        )
        drawRect(
            color = yellow,
            topLeft = Offset(0f, height.times(0.5f)),
            size = Size(width, height.times(0.5f))
        )
    }
}

@Composable
fun EmblemWithShield(
    modifier: Modifier = Modifier,
    emblemStrokeWidth: Float = 85f,
    emblemColor: Color = Color(0xFFFFDD00),
    shieldStrokeWidth: Float = 30f,
    shieldStrokeColor: Color = Color(0xFFFFDD00),
    shieldBackgroundColor: Color = Color(0xFF0057B7)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Shield(
            strokeWidth = shieldStrokeWidth,
            strokeColor = shieldStrokeColor,
            backgroundColor = shieldBackgroundColor
        )
        Emblem(
            modifier = Modifier
                .scale(0.68f)
                .offset(y = (-12).dp),
            strokeWidth = emblemStrokeWidth,
            color = emblemColor
        )
    }
}

@Composable
fun Emblem(
    modifier: Modifier = Modifier,
    strokeWidth: Float = 85f,
    color: Color
) {
    Box(
        modifier = modifier
    ) {
        VandYA(
            strokeWidth = strokeWidth,
            color = color
        )
        OandL(
            strokeWidth = strokeWidth,
            color = color
        )
    }
}

@Composable
fun VandYA(
    modifier: Modifier = Modifier,
    strokeWidth: Float,
    color: Color
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width.times(0.5f), height.times(0.732f))
            lineTo(width.times(0), height.times(0.732f))
            lineTo(width.times(0), height.times(0.208f))
            quadraticBezierTo(
                width.times(0.15f), height.times(0.26f),
                width.times(0.19f), height.times(0.338f)
            )
            lineTo(width.times(0.245f), height.times(0.533f))
            arcTo(
                rect = Rect(
                    left = width.times(0.135f),
                    top = height.times(0.513f),
                    right = size.width.times(0.4f),
                    bottom = height.times(0.631f)
                ),
                startAngleDegrees = 95f,
                sweepAngleDegrees = 175f,
                forceMoveTo = true
            )
            moveTo(width.times(0.25f), height.times(0.6304f))
            lineTo(width.times(0.39f), height.times(0.644f))
            arcTo(
                rect = Rect(
                    left = width.times(0.2f),
                    top = height.times(0.641f),
                    right = size.width.times(0.503f),
                    bottom = height.times(0.8f)
                ),
                startAngleDegrees = 4f,
                sweepAngleDegrees = -80f,
                forceMoveTo = true
            )
            moveTo(width.times(0.5f), height.times(0.7f))
            lineTo(width.times(0.5f), height.times(0.88f))
            moveTo(width.times(0f), height.times(0.571f))
            lineTo(width.times(0.15f), height.times(0.571f))
        }

        // "В"
        drawPath(
            path = path,
            color = color,
            style = Stroke(
                width = strokeWidth
            )
        )

        // "Я"
        scale(scaleX = -1f, scaleY = 1f, pivot = Offset(width / 2, height / 2)) {
            drawPath(
                path = path,
                color = color,
                style = Stroke(
                    width = strokeWidth
                )
            )
        }
    }
}

@Composable
fun OandL(
    modifier: Modifier = Modifier,
    strokeWidth: Float,
    color: Color
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width.times(0.525f), height.times(0.89f))
            quadraticBezierTo(
                width.times(0.16f), height.times(0.77f),
                width.times(0.37f), height.times(0.6f)
            )
            quadraticBezierTo(
                width.times(0.52f), height.times(0.47f),
                width.times(0.49f), height.times(0.35f)
            )
            quadraticBezierTo(
                width.times(0.435f), height.times(0.145f),
                width.times(0.52f), height.times(0.126f)
            )
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(
                width = strokeWidth
            )
        )
        scale(scaleX = -1f, scaleY = 1f, pivot = Offset(width / 2, height / 2)) {
            drawPath(
                path = path,
                color = color,
                style = Stroke(
                    width = strokeWidth
                )
            )
        }
    }
}

@Composable
fun Shield(
    modifier: Modifier = Modifier,
    strokeWidth: Float,
    strokeColor: Color,
    backgroundColor: Color,
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width.times(0.5f), height.times(0.185f))
            lineTo(width.times(0f), height.times(0.185f))
            lineTo(width.times(0f), height.times(0.67f))
            quadraticBezierTo(
                width.times(0.01f), height.times(0.71f),
                width.times(0.095f), height.times(0.735f)
            )
            lineTo(width.times(0.506f), height.times(0.818f))
        }

        drawPath(
            path = path,
            color = backgroundColor,
            style = Fill
        )
        scale(scaleX = -1f, scaleY = 1f, pivot = Offset(width / 2, height / 2)) {
            drawPath(
                path = path,
                color = backgroundColor,
                style = Fill
            )
        }
        drawPath(
            path = path,
            color = strokeColor,
            style = Stroke(
                width = strokeWidth
            )
        )
        scale(scaleX = -1f, scaleY = 1f, pivot = Offset(width / 2, height / 2)) {
            drawPath(
                path = path,
                color = strokeColor,
                style = Stroke(
                    width = strokeWidth
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmblemWithShieldAndBackgroundPreview() {
    HerbTheme {
        EmblemWithShield(
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmblemWithShieldPreview() {
    HerbTheme {
        EmblemWithShield(
            modifier = Modifier.padding(12.dp),
            shieldBackgroundColor = Color.Transparent
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmblemWithShieldBlackPreview() {
    HerbTheme {
        EmblemWithShield(
            modifier = Modifier.padding(12.dp),
            shieldBackgroundColor = Color.Transparent,
            emblemColor = Color.Black,
            shieldStrokeColor = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmblemBlackPreview() {
    HerbTheme {
        Emblem(
            modifier = Modifier.padding(12.dp),
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun FlagWithEmblem1Preview() {
    HerbTheme {
        Box {
            Flag()
            EmblemWithShield(
                modifier = Modifier
                    .scale(0.7f),
                shieldBackgroundColor = Color.Transparent,
                emblemColor = Color.White,
                shieldStrokeColor = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun FlagWithEmblem2Preview() {
    HerbTheme {
        Box {
            Flag()
            EmblemWithShield(
                modifier = Modifier.scale(0.7f),
            )
        }
    }
}
