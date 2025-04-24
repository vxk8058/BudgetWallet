// App.jsx
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import FrontPage from './pages/FrontPage';
import SavingsPage from './pages/SavingsPage';
import InvestmentPage from './pages/InvestmentPage';
import AccountPage from './pages/AccountPage';
import UnderConstructionPage from './pages/UnderConstructionPage';
import Login from './pages/login/login';
import Reset from './pages/login/reset';
import IncomePage from './pages/income';
import ExpensePage from './pages/expense';
import GoalsPage from './pages/FinancialGoalsPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/reset" element={<Reset />} />
        <Route path="/" element={<IncomePage />} />
        <Route path="/home" element={<IncomePage />} />
        <Route path="/Manage Financials" element={<IncomePage />} />
        <Route path="/Reports" element={<UnderConstructionPage />} />
        <Route path="/Financial Goals" element={<GoalsPage />} />
        <Route path="/Account" element={<AccountPage />} />
        <Route path="/Logout" element={<UnderConstructionPage />} />
        <Route path="/Manage Income Entries" element={<IncomePage />} />
        <Route path="/Manage Expense Entries" element={<ExpensePage />} />
        <Route path="/Manage Savings Entries" element={<SavingsPage />} />
        <Route path="/Manage Investment Entries" element={<InvestmentPage />} />  
      </Routes>
    </Router>
  );
}

export default App;
