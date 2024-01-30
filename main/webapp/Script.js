/**
 * 
 */
function updateCartDisplay() {
    const cartItemsList = document.getElementById('cartItemsList');
    const cartData = sessionStorage.getItem('cartData');
    let totalOrderAmount = 0;

    if (cartData) {
        const parsedCartData = JSON.parse(cartData);
        cartItemsList.innerHTML = '';

        parsedCartData.forEach(item => {
            const cartItem = document.createElement('li');
            const totalAmount = item.quantity * item.price;
            totalOrderAmount += totalAmount;

            cartItem.textContent = `${item.name} - Quantity: ${item.quantity}, Total Price: Rs.${totalAmount}`;
            cartItemsList.appendChild(cartItem);
        });
    }

    // Display the total order amount
    const totalOrderElement = document.createElement('li');
    totalOrderElement.textContent = `Total Order Amount: Rs.${totalOrderAmount}`;
    cartItemsList.appendChild(totalOrderElement);
}

function toggleCart() {
    const cartSection = document.getElementById('cartSection');
    cartSection.style.display = (cartSection.style.display === 'none' || cartSection.style.display === '') ? 'block' : 'none';
}

// Function to handle the "Shop Now" button click
function shopNow() {
    // Add your logic here to redirect to the shopping page or perform any other action
    alert("Your order succssfully")
}

// Initial update to display any existing cart items
updateCartDisplay();