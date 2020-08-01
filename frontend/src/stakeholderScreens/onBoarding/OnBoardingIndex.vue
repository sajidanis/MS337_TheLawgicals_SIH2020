<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="onBoardingNavItems" :miniVariant="miniVariant" />
        <v-main app>
            <v-container>
                <router-view></router-view>
            </v-container>
        </v-main>

        <Footer />
    </div>
</template>

<script>
import SideBar from '@/dashboard/layout/SideBar.vue'
import AppBar from '@/dashboard/layout/AppBar.vue'
import Footer from '@/dashboard/layout/Footer.vue'

export default {
    name: 'OnBoardingIndex',
    methods: {
        changeMiniVariant() {
            this.miniVariant = !this.miniVariant
        },
    },
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            miniVariant: true,
            onBoardingNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: '',
                },
                {
                    title: 'Add User',
                    icon: '',
                    route: { name: 'AddUser' },
                },
                {
                    title: 'View All ',
                    icon: '',
                    route: '/onboarding/viewAll',
                },
                {
                    title: 'All User Roles ',
                    icon: 'fa-users ',
                    route: { name: 'AllUserRoles' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
