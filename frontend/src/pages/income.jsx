import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import myImage from '../images/v97_24.png';

// Main IncomePage Component
export default function IncomePage() {
  const [amount, setAmount] = useState('');
  const [category, setCategory] = useState('');
  const [date, setDate] = useState('');
  const [entries, setEntries] = useState([]);
  
  useEffect(() => {
    /*
      // Fetch income entries from Java backend on component mount
      fetch('http://localhost:8080/api/income')
        .then(response => {
          if (!response.ok) {
            throw new Error('Failed to fetch income entries');
          }
          return response.json();
        })
        .then(data => {
          // Update local state with entries from backend
          setEntries(data);
        })
        .catch(error => {
          console.error('Error loading income entries:', error);
        });
    */
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (amount && category && date) {
      const newEntry = { amount, category, date };
      setEntries([...entries, newEntry]);
      setAmount('');
      setCategory('');
      setDate('');

      /*
      fetch('http://localhost:8080/api/income', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newEntry),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error('Failed to save income entry');
          }
          return response.json();
        })
        .then((data) => {
          console.log('Income saved:', data);
        })
        .catch((error) => {
          console.error('Error saving income:', error);
        });
      */
    }
  };
  
  const handleDelete = (indexToRemove) => {
    const entryToDelete = entries[indexToRemove];
  
    // Remove from frontend state
    setEntries(entries.filter((_, index) => index !== indexToRemove));
  
    /*
      // Replace `entryToDelete.id` with the actual ID from the database once available
      fetch(`http://localhost:8080/api/income/${entryToDelete.id}`, {
        method: 'DELETE',
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error('Failed to delete income entry');
          }
          console.log('Income entry deleted');
        })
        .catch((error) => {
          console.error('Error deleting income entry:', error);
        });
    */
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
              backgroundColor: '#3B4471', 
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
              backgroundColor: '#BCC0CE', 
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
        <Link to="/manage income entries" style={{ textDecoration: 'none' }}>
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
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Manage Income Entries</span>
          </div>
        </Link>
        
        <Link to="/manage expense entries" style={{ textDecoration: 'none' }}>
          <div style={{ 
            width: '190px', 
            height: '80px', 
            backgroundColor: '#F0F2F9', 
            display: 'flex', 
            justifyContent: 'center', 
            alignItems: 'center', 
            color: 'black', 
            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
            cursor: 'pointer'
          }}>
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Manage Expense Entries</span>
          </div>
        </Link>
        
        <Link to="/manage savings entries" style={{ textDecoration: 'none' }}>
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
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px', color: '#000000' }}>Manage Savings Entries</span>
          </div>
        </Link>
        
        <Link to="/manage investment entries" style={{ textDecoration: 'none' }}>
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
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Manage Investment Entries</span>
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
          <form onSubmit={handleSubmit} style={{ width: '100%', maxWidth: '500px' }}>
            <div style={{ marginBottom: '20px' }}>
              <label style={{ display: 'block', marginBottom: '5px', fontFamily: 'Kaisei Decol', fontSize: '20px' }}>
                Income amount
              </label>
              <input
                style={{ 
                  width: '100%', 
                  height: '36px', 
                  backgroundColor: '#FFFFFF',
                  border: 'none',
                  paddingLeft: '10px'
                }}
                type="number"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                placeholder="Enter amount"
                required
              />
            </div>
            
            <div style={{ marginBottom: '20px' }}>
              <label style={{ display: 'block', marginBottom: '5px', fontFamily: 'Kaisei Decol', fontSize: '20px' }}>
                Category
              </label>
              <select
                style={{ 
                  width: '100%', 
                  height: '36px', 
                  backgroundColor: '#FFFFFF',
                  border: 'none',
                  borderRadius: '20px',
                  paddingLeft: '10px',
                  fontFamily: 'Kaisei Decol'
                }}
                value={category}
                onChange={(e) => setCategory(e.target.value)}
                required
              >
                <option value="" disabled>Select a category</option>
                <option value="Salary">Salary</option>
                <option value="Tip">Tip</option>
                <option value="Commission">Commission</option>
                <option value="Bonus">Bonus</option>
              </select>
            </div>
            
            <div style={{ marginBottom: '20px' }}>
              <label style={{ display: 'block', marginBottom: '5px', fontFamily: 'Kaisei Decol', fontSize: '20px' }}>
                Date
              </label>
              <input
                style={{ 
                  width: '100%', 
                  height: '36px', 
                  backgroundColor: '#FFFFFF',
                  border: 'none',
                  paddingLeft: '10px'
                }}
                type="date"
                value={date}
                onChange={(e) => setDate(e.target.value)}
                required
              />
            </div>
            
            <div style={{ display: 'flex', justifyContent: 'center' }}>
              <button
                style={{ 
                  width: '106px', 
                  height: '36px', 
                  backgroundColor: '#FFFFFF',
                  border: 'none',
                  borderRadius: '20px',
                  fontFamily: 'Kaisei Decol',
                  fontSize: '20px',
                  cursor: 'pointer'
                }}
                type="submit"
              >
                Save
              </button>
            </div>
          </form>
        </div>
      </div>
      
      {/* Income Entries List */}
      <div style={{ 
        position: 'absolute', 
        top: '670px', 
        left: '250px', 
        width: '750px',
        backgroundColor: '#FFFFFF',
        borderRadius: '45px',
        padding: '20px',
        marginBottom: '30px'
      }}>
        <h3 style={{ fontFamily: 'Kaisei Decol', fontSize: '24px', marginBottom: '20px' }}>Income Entries</h3>
        {entries.length > 0 ? (
          <ul style={{ listStyle: 'none', padding: '0' }}>
            {entries.map((entry, index) => (
              <li key={index} style={{ 
                padding: '10px', 
                margin: '5px 0', 
                backgroundColor: '#F5F5F5',
                borderRadius: '10px',
                fontFamily: 'Kaisei Decol'
              }}>
                <span>{entry.date} / {entry.category} - ${entry.amount}</span>
                <button 
                  onClick={() => handleDelete(index)} 
                  style={{
                    marginLeft: '10px',
                    backgroundColor: '#FF6B6B',
                    border: 'none',
                    borderRadius: '10px',
                    color: 'white',
                    cursor: 'pointer',
                    padding: '5px 10px',
                    fontFamily: 'Kaisei Decol'
                  }}
                >
                  Delete
                </button>

              </li>
            ))}
          </ul>
        ) : (
          <p style={{ fontFamily: 'Kaisei Decol', color: '#666' }}>No entries yet. Add your first income entry above.</p>
        )}
      </div>
    </div>
  );
}