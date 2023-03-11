package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    valueText: String,
    hint: String,
    textColor: Color,
    //imageVector: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (String) -> Unit,
    trailingIcon: ImageVector? = null,
    leadingIcon: ImageVector,
    onTrailingIconClicked: (() -> Unit)?,
    cursorColor: Color
) {
    OutlinedTextField(
        value = valueText,
        onValueChange = onValueChanged,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp)
            .height(60.dp)
            .shadow(4.dp),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = cursorColor,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodySmall
            )
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        trailingIcon = {
            if(trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clickable {
                            onTrailingIconClicked?.invoke()
                            //if(onTrailingIconClicked != null) onTrailingIconClicked()
                        }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EditTextFieldPreview() {
    EditTextField(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp, 0.dp,10.dp,5.dp),
        hint = "JohnDeo@Gmail.com",
        leadingIcon = Icons.Default.Email,
        valueText = "TextInput",
        textColor = Color.Black,
        cursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
        onValueChanged = { },
        trailingIcon = Icons.Filled.RemoveRedEye,
        onTrailingIconClicked = { },
        visualTransformation = PasswordVisualTransformation()
    )
}