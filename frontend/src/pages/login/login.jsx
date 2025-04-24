import { Box, Button, TextField, Typography } from "@mui/material";
import { useState } from "react";//react hook
import Link from '@mui/material/Link';

//these hold empty strings that get filled when user enters information
export default function Login() {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    //when login button is clicked send the request to the backend sever to verify
    const submitLogin = async () => {
        const url = "http://localhost:8080/login";
        const loginInfo = { "email": email, "password": password }
        console.log(loginInfo)
        try {
            const response = await fetch(url, {
                method: "POST",
                body: JSON.stringify(loginInfo),
            });

            if (!response.ok) {
                throw new Error(`Response status: ${response.status}`);
            }

            const json = await response.json();
            console.log(json);
            //if login successfull got redirect to home page
        } catch (error) {
            console.error(error.message);
        }
    }

    return (

        //full page style container
        <Box sx={{ height: '1024px', width: '1440px', margin: 'auto', display: 'flex', gap: 2, flexDirection: 'column', justifyContent: 'center', backgroundColor: "#8A93B4", }}>

            <Box sx={{ width: "733px", height: "743px", backgroundColor: "#F5F4F4", borderRadius: "30px", margin: 'auto', display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', gap: 5 }}>
                <Typography sx={{ fontFamily: "Kaisei Decol", color: "#000000", fontSize: "48px" }}>
                    Login
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

                        //overrides the mui type box with custom type box
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
                <TextField
                    id="outlined-password-input"
                    label="Password"
                    type="password"
                    autoComplete="current-password"


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
                        setPassword(event.target.value);
                    }}
                />

                <Link href="/reset">
                    <Typography sx={{ fontFamily: "Kaisei Decol", color: "#969696", fontSize: "24px" }}>
                        Forgot Password?
                    </Typography></Link>
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
                    onClick={submitLogin}>
                    Sign In
                </Button>


                <Box sx={{ width: "100%", display: "flex", justifyContent: "center", }}>
                    <Typography sx={{ fontFamily: "Kaisei Decol", color: "#969696", fontSize: "24px" }}>
                        Create An Account
                    </Typography>
                </Box>


            </Box>
        </Box>
    )

}
