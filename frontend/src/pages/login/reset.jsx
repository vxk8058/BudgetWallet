import { Box, Button, TextField, Typography } from "@mui/material";
import { useState } from "react";

//these hold empty strings that get filled when user enters information
export default function Reset() {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    //when login button is clicked send the request to the backend link
    const sendResetLink = async () => {
        const url = "http://localhost:8080/reset";
        const loginInfo = { "email": email }
        console.log(loginInfo)
        try {
            const response = await fetch(url, {
                method: "POST",
                body: JSON.stringify(loginInfo),
            });
            if (!response.ok) {
                throw new Error(`Response status: ${response.status}`);
            } 3

            const json = await response.json();
            console.log(json);
            //if login successfull got redirect to home page
        } catch (error) {
            console.error(error.message);
        }
    }

    return (
        <Box sx={{ height: '1024px', width: '1440px', margin: 'auto', display: 'flex', gap: 2, flexDirection: 'column', justifyContent: 'center', backgroundColor: "#8A93B4", }}>

            <Box sx={{ width: "733px", height: "743px", backgroundColor: "#F5F4F4", borderRadius: "30px", margin: 'auto', display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', gap: 5 }}>
                <Typography sx={{ fontFamily: "Kaisei Decol", color: "#000000", fontSize: "48px" }}>
                    Reset Password
                </Typography>


                <TextField
                    id="email"
                    label="Email"
                    variant="outlined"

                    sx={{
                        backgroundColor: "#8A93B4", borderRadius: "30px",
                        width: "492px",
                        height: "87px",

                        fontSize: "48px",
                        fontFamily: "Kaisei Decol",
                        color: "#DFDADA",
                        textTransform: "none",
                        '& .MuiInputBase-root': {
                            borderRadius: "30px", // Rounded edges for the input itself
                        },
                        '& .MuiOutlinedInput-notchedOutline': {
                            border: "none", // Removes the outline (the border)
                        },
                        '& .MuiInputLabel-root': {
                            fontSize: "36px", // Larger label font size
                            color: "#DFDADA", // Label color
                        },
                        '& .MuiInputBase-input': {
                            padding: "18px", // Adjust padding for input text
                        }
                    }}


                    onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                        setEmail(event.target.value);
                    }}
                />

                <Button
                    variant="contained"
                    sx={{
                        backgroundColor: "#354272", borderRadius: "30px",
                        width: "492px",
                        height: "87px",
                        fontSize: "48px",
                        fontFamily: "Kaisei Decol",
                        color: "#000000",
                        textTransform: "none",
                    }}
                    onClick={sendResetLink}>
                    Send Reset Link
                </Button>


            </Box>
        </Box>
    )

}
