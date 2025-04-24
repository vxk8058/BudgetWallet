import { useNavigate } from 'react-router-dom';

export default function UnderConstructionPage() {
  const navigate = useNavigate();
  
  return (
    <div style={{ 
      backgroundColor: 'rgba(138,147,180,1)', 
      minHeight: '100vh', 
      display: 'flex', 
      flexDirection: 'column', 
      justifyContent: 'center', 
      alignItems: 'center' 
    }}>
      <div style={{ 
        backgroundColor: '#FFFFFF',
        borderRadius: '45px',
        padding: '40px',
        maxWidth: '600px',
        textAlign: 'center',
        boxShadow: '0px 4px 4px rgba(0,0,0,0.25)'
      }}>
        <h2 style={{ fontFamily: 'Kaisei Decol', fontSize: '32px', marginBottom: '20px' }}>
          Under Construction
        </h2>
        <p style={{ fontFamily: 'Kaisei Decol', fontSize: '18px', marginBottom: '30px' }}>
          This page is currently under development. Please check back later.
        </p>
        <button 
          onClick={() => navigate('/')}
          style={{ 
            padding: '10px 20px',
            backgroundColor: '#3B4471',
            color: 'white',
            border: 'none',
            borderRadius: '20px',
            fontFamily: 'Kaisei Decol',
            fontSize: '18px',
            cursor: 'pointer',
            boxShadow: '0px 4px 4px rgba(0,0,0,0.25)'
          }}
        >
          Return
        </button>
      </div>
    </div>
  );
}