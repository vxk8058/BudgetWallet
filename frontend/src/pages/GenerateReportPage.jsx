import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import myImage from '../images/v97_24.png';

// Main GenerateReportPage Component
export default function GenerateReportPage() {
    const [startMonth, setStartMonth] = useState('');
    const [endMonth, setEndMonth] = useState('');
    const [reportData, setReportData] = useState('');

    useEffect(() => {

    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();

        setReportData(`Financial Report
Start Date: ${startMonth}
    Total Income: $5,000
    Total Savings: $1,200
    Total Investment: $800
    Total Expenses: $3,000
End Date: ${endMonth}`);
    };

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
                        backgroundColor: '#3B4471',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center',
                        color: 'black',
                        boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
                        cursor: 'pointer'
                    }}>
                        <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Generate Report</span>
                    </div>
                </Link>

                <Link to="/MonthlyReport" style={{ textDecoration: 'none' }}>
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
                <h2 style={{ textAlign: 'center', fontFamily: 'Kaisei Decol', marginBottom: '20px' }}>Generate Financial Report</h2>

                {/* Input Form Section */}
                <div style={{
                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                    gap: '15px',
                    marginBottom: '20px'
                }}>
                    <div style={{ display: 'flex', alignItems: 'center' }}>
                        <label style={{ marginRight: '10px', fontFamily: 'Kaisei Decol' }}>Start Month:</label>
                        <input
                            type="month"
                            value={startMonth}
                            onChange={(e) => setStartMonth(e.target.value)}
                            style={{
                                padding: '8px',
                                borderRadius: '5px',
                                border: '1px solid #ccc'
                            }}
                        />
                    </div>

                    <div style={{ display: 'flex', alignItems: 'center' }}>
                        <label style={{ marginRight: '10px', fontFamily: 'Kaisei Decol' }}>End Month:</label>
                        <input
                            type="month"
                            value={endMonth}
                            onChange={(e) => setEndMonth(e.target.value)}
                            style={{
                                padding: '8px',
                                borderRadius: '5px',
                                border: '1px solid #ccc'
                            }}
                        />
                    </div>

                    <button
                        onClick={handleSubmit}
                        style={{
                            backgroundColor: '#3B4471',
                            color: 'white',
                            padding: '8px 15px',
                            borderRadius: '5px',
                            border: 'none',
                            cursor: 'pointer',
                            fontFamily: 'Kaisei Decol',
                            boxShadow: '0px 2px 2px rgba(0,0,0,0.25)'
                        }}
                    >
                        Generate Financial Report
                    </button>
                </div>

                {/* Report Output Area */}
                <div style={{
                    backgroundColor: '#D9D9D9',
                    flex: 1,
                    borderRadius: '30px',
                    padding: '20px',
                    display: 'flex',
                    flexDirection: 'column'
                }}>
          <textarea
              value={reportData}
              readOnly
              placeholder="Select start and end months, then click 'Generate Report' to view financial data"
              style={{
                  width: '100%',
                  height: '100%',
                  backgroundColor: 'transparent',
                  border: 'none',
                  resize: 'none',
                  fontFamily: 'monospace',
                  fontSize: '16px',
                  lineHeight: '1.5',
                  padding: '10px',
                  boxSizing: 'border-box'
              }}
          />
                </div>
            </div>
        </div>
    );
}