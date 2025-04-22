========================
        USER APIs
========================
POST    /api/users                - Create a new user
GET     /api/users                - Get all users 
GET     /api/users/{id}          - Get user by ID --if data is not present for particular id
PUT     /api/users/{id}          - Update user by ID
DELETE  /api/users/{id}          - Delete user

======================== 
      CATEGORY APIs
========================
POST    /api/categories           - Create a category
GET     /api/categories           - Get all categories
GET     /api/categories/{id}     - Get category by ID
PUT     /api/categories/{id}     - Update category
DELETE  /api/categories/{id}     - Delete category

========================
     TESTIMONIAL APIs
========================
POST    /api/testimonials         - Add or update testimonial
GET     /api/testimonials         - Get all testimonials
DELETE  /api/testimonials/{id}   - Delete testimonial

========================
     NOTIFICATION APIs
========================
POST    /api/notifications                - Send/create notification
GET     /api/notifications                - Get all notifications
GET     /api/notifications/user/{id}     - Get notifications for user
PUT     /api/notifications/{id}          - Update notification
DELETE  /api/notifications/{id}          - Delete notification

========================
       COURSE APIs
========================
POST    /api/courses              - Create a new course
GET     /api/courses              - Get all courses
GET     /api/courses/{id}        - Get course by ID
PUT     /api/courses/{id}        - Update course
DELETE  /api/courses/{id}        - Delete course
GET     /api/courses/category/{categoryId} - Get courses by category

yet to be done
========================
   COURSE SUBSCRIPTION APIs
========================
POST    /api/subscriptions               - Subscribe user to course
GET     /api/subscriptions               - Get all subscriptions
GET     /api/subscriptions/user/{id}    - Get subscriptions for user
GET     /api/subscriptions/course/{id}  - Get subscriptions for course
PUT     /api/subscriptions/{id}         - Update subscription
DELETE  /api/subscriptions/{id}         - Cancel subscription

========================
     TRANSACTION APIs
========================
POST    /api/transactions                - Create transaction
GET     /api/transactions                - Get all transactions
GET     /api/transactions/user/{id}     - Get user transaction history
GET     /api/transactions/{id}          - Get transaction details
PUT     /api/transactions/{id}          - Update transaction (e.g., refund)

========================
 CUSTOMER SERVICE CHAT APIs
========================
POST    /api/chats                        - Send a chat message
GET     /api/chats/session/{sessionId}    - Get messages in session
GET     /api/chats/user/{userId}          - Get user chat history
PUT     /api/chats/{id}/read              - Mark message as read
DELETE  /api/chats/{id}                   - Delete chat message

========================
    AUTHENTICATION APIs
========================
POST    /api/auth/register         - Register user
POST    /api/auth/login            - Login and return token

========================
   OPTIONAL DASHBOARD APIs
========================
GET     /api/dashboard/user/{id}   - User dashboard overview
GET     /api/stats/courses         - Popular course stats
GET     /api/export/users          - Export users as CSV
