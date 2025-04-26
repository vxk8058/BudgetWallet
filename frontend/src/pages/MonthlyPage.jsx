import React, { useState, useEffect } from 'react';
import { PieChart } from '@mui/x-charts/PieChart';
import { Link } from 'react-router-dom';
import myImage from '../images/v97_24.png';

// Main MonthlyPage Component
export default function MonthlyPage() {
    const [entries, setEntries] = useState([]);
    useEffect(() => {
          // Fetch goal entries from Java backend on component mount
          fetch('http://localhost:8080/api/goal')
              .then(response => {
                  if (!response.ok) {
                      throw new Error('Failed to fetch goal entries');
                }
                return response.json();
              })
              .then(data => {
                  // Update local state with entries from backend
                  setEntries(data);
              })
              .catch(error => {
                  console.error('Error loading goal entries:', error);
              });
    }, []);

    return (
        <div style={{ backgroundColor: 'rgba(138,147,180,1)', minHeight: '100vh', position: 'relative' }}>
            {/* Header/Navigation Bar */}
            <div style={{
                width: '100%',
                height: '131px',
                backgroundColor: 'rgba(245,243,243,1)',
                position: 'relative'
            }}>
                <Link to="/home" style={{ textDecoration: 'none' }}>
                    <div style={{ position: 'absolute', top: '20px', left: '40px' }}>
                        <img src={myImage} alt="logo" width="100" height="100" />
                    </div>
                </Link>
                {/* Navigation buttons */}
                <div style={{ display: 'flex', position: 'absolute', top: '20px', left: '220px', gap: '10px' }}>
                    <Link to="/Manage Financials" style={{ textDecoration: 'none' }}>
                        <div style={{
                            width: '172px',
                            height: '40px',
                            backgroundColor: '#BCC0CE',
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: 'black',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                            cursor: 'pointer'
                        }}>
                            Manage Financials
                        </div>
                    </Link>
                    <Link to="/reports" style={{ textDecoration: 'none' }}>
                        <div style={{
                            width: '172px',
                            height: '40px',
                            backgroundColor: '#3B4471',
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: 'black',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                            cursor: 'pointer'
                        }}>
                            Reports
                        </div>
                    </Link>
                    <Link to="/financial Goals" style={{ textDecoration: 'none' }}>
                        <div style={{
                            width: '172px',
                            height: '40px',
                            backgroundColor: '#BCC0CE',
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: 'black',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                            cursor: 'pointer'
                        }}>
                            Financial Goals
                        </div>
                    </Link>
                    <Link to="/account" style={{ textDecoration: 'none' }}>
                        <div style={{
                            width: '172px',
                            height: '40px',
                            backgroundColor: '#BCC0CE',
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: 'black',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                            cursor: 'pointer'
                        }}>
                            Account
                        </div>
                    </Link>
                    <Link to="/Logout" style={{ textDecoration: 'none' }}>
                        <div style={{
                            width: '172px',
                            height: '40px',
                            backgroundColor: '#BCC0CE',
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: 'black',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                            cursor: 'pointer'
                        }}>
                            Logout
                        </div>
                    </Link>
                </div>
            </div>

            {/* Sidebar */}
            <div style={{ position: 'absolute', top: '150px', left: '15px', display: 'flex', flexDirection: 'column', gap: '20px' }}>
                <Link to="/GenerateReport" style={{ textDecoration: 'none' }}>
                    <div style={{
                        width: '190px',
                        height: '80px',
                        backgroundColor: '#FFFFFF',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center',
                        color: 'black',
                        boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                        cursor: 'pointer'
                    }}>
                        <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Generate Financial Report</span>
                    </div>
                </Link>

                <Link to="/MonthlyReport" style={{ textDecoration: 'none' }}>
                    <div style={{
                        width: '190px',
                        height: '80px',
                        backgroundColor: '#3B4471',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center',
                        color: 'black',
                        boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                        cursor: 'pointer'
                    }}>
                        <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Monthly Report</span>
                    </div>
                </Link>
            </div>

            {/* Main Content Area */}
            <div style={{
                position: 'absolute',
                top: '150px',
                left: '250px',
                width: '750px',
                height: '500px',
                backgroundColor: '#FFFFFF',
                borderRadius: '45px',
                boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                padding: '20px',
                display: 'flex',
                flexDirection: 'column'
            }}>


                {/* Form Area */}
                <div style={{
                    backgroundColor: '#D9D9D9',
                    flex: 1,
                    borderRadius: '30px',
                    padding: '20px',
                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center'
                }}>
                    {/*for demo*/}
                    {/*<PieChart*/}
                    {/*    series={[*/}
                    {/*        {*/}
                    {/*            data: [*/}
                    {/*                { id: 0, value: 10, label: 'Income' },*/}
                    {/*                { id: 1, value: 15, label: 'Expense' },*/}
                    {/*                { id: 2, value: 20, label: 'Savings' },*/}
                    {/*                { id: 4, value: 20, label: 'Investment' },*/}
                    {/*            ],*/}
                    {/*        },*/}
                    {/*    ]}*/}
                    {/*    width={200}*/}
                    {/*    height={200}*/}
                    {/*/>*/}
                </div>
            </div>
        </div>
    );
}