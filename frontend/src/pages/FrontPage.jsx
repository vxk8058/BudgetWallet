// FrontPage.jsx
import { Link } from 'react-router-dom';
import myImage from '../images/v97_24.png';

function FrontPage() {
  return (
    <div style={{ 
      width: '100%', 
      height: '131px', 
      backgroundColor: 'rgba(245,243,243,1)',
      position: 'relative'
    }}>
      <Link to="/home" style={{ textDecoration: 'none' }}>
        <div style={{ position: 'absolute', top: '20px', left: '40px' }}>
          {/*<h2 style={{ fontFamily: 'serif', fontWeight: 'bold', fontSize: '32px', margin: 0 }}>BW</h2>
          <span style={{ fontSize: '12px', letterSpacing: '1px' }}>BUDGETWALLET</span>*/}
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

      <div style={{ position: 'absolute', top: '150px', left: '15px', display: 'flex', flexDirection: 'column', gap: '20px' }}>
        <Link to="/manage income entries" style={{ textDecoration: 'none' }}>
          <div style={{ 
            width: '190px', 
            height: '80px', 
            backgroundColor: '#3B4471', 
            display: 'flex', 
            justifyContent: 'center', 
            alignItems: 'center', 
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
            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
            cursor: 'pointer'
          }}>
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Manage Savings Entries</span>
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
            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)',
            cursor: 'pointer'
          }}>
            <span style={{ fontFamily: 'Kaisei Decol', fontSize: '24px' }}>Manage Investment Entries</span>
          </div>
        </Link>
      </div>
    </div>
  );
}

export default FrontPage;
