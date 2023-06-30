/**

 Represents a user entity.
 */
package com.kino.kino_backend.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String name;

        @Column(unique = true)
        private String email;

        private String password;

        private String surname;

        private int age;

        @OneToMany(cascade = CascadeType.ALL)
        private List<Reservation> reservations;

        @OneToMany//(mappedBy = "movies")
        private List<MessageComplaint> messageComplaints;


        /**
         * Returns the ID of the user.
         *
         * @return the ID of the user
         */
        public int getId() {
                return id;
        }

        /**
         * Sets the ID of the user.
         *
         * @param id the ID of the user
         */
        public void setId(int id) {
                this.id = id;
        }

        /**
         * Returns the name of the user.
         *
         * @return the name of the user
         */
        public String getName() {
                return name;
        }


        /**
         * Sets the name of the user.
         *
         * @param name the name of the user
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * Returns the email of the user.
         *
         * @return the email of the user
         */
        public String getEmail() {
                return email;
        }


        /**
         * Sets the email of the user.
         *
         * @param email the email of the user
         */
        public void setEmail(String email) {
                this.email = email;
        }

        @Enumerated(EnumType.STRING)
        private Role role;
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(role.name()));
        }

        /**
         * Returns the password of the user.
         *
         * @return the password of the user
         */
        @Override
        public String getPassword() {
                return password;
        }


        /**
         * Returns the surname of the user.
         *
         * @return the surname of the user
         */
        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

        public List<Reservation> getReservations() {
                return reservations;
        }

        public void setReservations(List<Reservation> reservations) {
                this.reservations = reservations;
        }
}
